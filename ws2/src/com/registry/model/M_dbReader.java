package com.registry.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;


public class M_dbReader {
    private final String MEMBER = "member";
    private final String NAME = "name";
    private final String P_NUMBER = "p_number";
    private final String M_ID = "m_id";
    private final String BOATS = "Boat";
    private final String N_BOATS = "n_boats";
    private final String TYPE_BOATS = "type_boats";
    private final String LENGTH = "length";
    private final String TYPE = "type";
    private String dbFile;

    public List<Member> members = new ArrayList<Member>();

    public M_dbReader(String dbFile){
        this.dbFile = dbFile;
    }

    @SuppressWarnings({ "unchecked", "null" })
    public List<Member> readFromDB(String dbFile) {
        members = new ArrayList<>();
        //List<Member> items = new ArrayList<Member>();
        try {
            // First, create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            InputStream in = new FileInputStream(dbFile);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            // read the XML document
            Member member = null;
            ArrayList<String> temp = new ArrayList<String>();
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    // If we have an member element, we create a new member
                    String length = "";
                    if (startElement.getName().getLocalPart().equals(MEMBER)) {
                        member = new Member();
                        // We read the attributes from this tag and add the date
                        // attribute to our object
                        Iterator<Attribute> attributes = startElement
                                .getAttributes();
                    }

                    if (event.isStartElement()) {
                        if (event.asStartElement().getName().getLocalPart()
                                .equals(NAME)) {
                            event = eventReader.nextEvent();
                            member.setName(event.asCharacters().getData());
                            continue;
                        }
                    }

                    if (event.isStartElement()) {
                        if (event.asStartElement().getName().getLocalPart()
                                .equals(P_NUMBER)) {
                            event = eventReader.nextEvent();
                            member.setP_number(event.asCharacters().getData());
                            continue;
                        }
                    }
                    if (event.asStartElement().getName().getLocalPart()
                            .equals(M_ID)) {
                        event = eventReader.nextEvent();
                        member.setM_id(event.asCharacters().getData());
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart()
                            .equals(N_BOATS)) {
                        event = eventReader.nextEvent();
                        member.setN_boats(event.asCharacters().getData());
                        continue;
                    }

                    String type ;
                    if (event.asStartElement().getName().getLocalPart()
                            .equals(LENGTH)) {
                        event = eventReader.nextEvent();
                        length = event.asCharacters().getData();
                        temp.add(length);
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart()
                            .equals(TYPE)) {
                        event = eventReader.nextEvent();
                        type = event.asCharacters().getData();

                        member.addBoat(type, temp.get(0));
                        temp.clear();
                        continue;
                    }

                }
                // If we reach the end of an member element, we add it to the list
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals(MEMBER)) {
                        members.add(member);
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        //System.out.println(items.get(2));
        return members;
    }


}
