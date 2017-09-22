package com.registry.model;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;

public class M_dbWriter {

    // create an XMLOutputFactory
    private XMLOutputFactory outputFactory;
    // create XMLEventWriter
    private XMLEventWriter eventWriter;
    private XMLEventFactory eventFactory;
    private XMLEvent end;
    private XMLEvent tab;
    private String dbFile;


    public M_dbWriter(String dbFile){
        this.dbFile = dbFile;
    }

    public void writeToDB(List<Member> list) throws Exception {
        outputFactory = XMLOutputFactory.newInstance();
        eventFactory = XMLEventFactory.newInstance();
        end = eventFactory.createDTD("\n");
        tab = eventFactory.createDTD("\t");
        eventWriter = outputFactory
                .createXMLEventWriter(new FileOutputStream(dbFile));

        StartDocument startDocument = eventFactory.createStartDocument();
        eventWriter.add(startDocument);
        eventWriter.add(end);

        // Write the different nodes
        StartElement start = eventFactory.createStartElement("","","Registry");

        eventWriter.add(start);
        eventWriter.add(end);

        // Looping and creating member nodes
        for(int i = 0; i < list.size(); i++){

            StartElement configStartElement = eventFactory.createStartElement("",
                    "", "member");
            eventWriter.add(tab);
            eventWriter.add(configStartElement);
            eventWriter.add(end);
            createMemberElement(eventWriter, list.get(i).getName(), list.get(i).getP_number(), list.get(i).getM_id(),
                    list.get(i).getN_boats(), list.get(i).getType_boats(), list.get(i));
            eventWriter.add(tab);
            eventWriter.add(eventFactory.createEndElement("", "", "member"));
            eventWriter.add(end);

        }
        EndElement stop = eventFactory.createEndElement("","","Registry");

        eventWriter.add(stop);
        eventWriter.add(eventFactory.createEndDocument());
        eventWriter.close();
    }

    private void createMemberElement(XMLEventWriter eventWriter, String name, String p_number, String m_id
    , String n_boats, String type_boats, Member member) throws Exception{
        createNode(eventWriter, "name", name);
        createNode(eventWriter, "p_number", p_number);
        createNode(eventWriter, "m_id", m_id);

        StartElement testElement = eventFactory.createStartElement("", "", "Boat");

        eventWriter.add(tab);
        eventWriter.add(tab);
        eventWriter.add(testElement);
        eventWriter.add(end);

        createBoatElement(member.getBoats(), eventWriter);


        EndElement testEndElement = eventFactory.createEndElement("", "", "Boat");
        eventWriter.add(tab);
        eventWriter.add(tab);
        eventWriter.add(testEndElement);
        eventWriter.add(end);

    }

    private void createBoatElement(ArrayList<Boat> boats, XMLEventWriter eventWriter) throws Exception{
        if(boats.size() == 0){

        }else {
            for(int i = 0; i < boats.size(); i++){
                eventWriter.add(tab);
                createNode(eventWriter, "length", boats.get(i).getLength());

                eventWriter.add(tab);
                createNode(eventWriter, "type", boats.get(i).getType());
            }
        }

    }
    private void createNode(XMLEventWriter eventWriter, String name,
                            String value) throws XMLStreamException {

        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        XMLEvent end = eventFactory.createDTD("\n");
        XMLEvent tab = eventFactory.createDTD("\t");
        // create Start node
        StartElement sElement = eventFactory.createStartElement("", "", name);
        eventWriter.add(tab);
        eventWriter.add(tab);
        eventWriter.add(sElement);
        // create Content
        Characters characters = eventFactory.createCharacters(value);
        eventWriter.add(characters);
        // create End node
        EndElement eElement = eventFactory.createEndElement("", "", name);
        eventWriter.add(eElement);
        eventWriter.add(end);

    }
}
