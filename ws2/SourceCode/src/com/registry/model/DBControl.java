package com.registry.model;



import java.util.List;

/**
 * Main class for reading and writing to the XML file.
 * A List is the representaion work object for the "DB"
 *Implementing a Interface to easily change type of persistance.
 */
public class DBControl implements IDBControl {


    private String dbFile = "src/com/registry/db.xml"; // File for debugging
    //private String dbFile = "./db.xml"; // File for .jar
    private DBReader db_read = new DBReader(dbFile);
    private DBWriter db_write = new DBWriter(dbFile);

    private List<Member> dbList;

    public DBControl(){
        dbList = db_read.readFromDB(dbFile);
    }

    // Different actions that can be taken towards the XML file
    public List<Member> getMembers(){
        return dbList;
    }
    public void saveMember(){

        writeToFile(dbList);
    }
    public void addMember(Member member){
        int uniqueId = dbList.get(dbList.size()-1).getM_id();
        uniqueId++;
        member.setM_id(uniqueId);
        dbList.add(member);
        writeToFile(dbList);
    }
    public Member getMember(int id){
        Member member = null;
        for(Member m : dbList){
            if(m.getM_id() == id){
                member = m;
            }
        }
        return member;
    }
    public boolean memberExists(int id){

        for(Member member : dbList){
            if(member.getM_id() == id){
                return true;
            }
        }
        return false;
    }
    public void deleteMember(Member member){
        dbList.remove(member);
        writeToFile(dbList);
    }

    // Private methods

    /**
     * Gets called to update the dbFile
     */
    private void updateDBFile(){
        dbList = db_read.readFromDB(dbFile);
    }

    /**
     * Writes the dbList file to the XML
     * @param dbList to be written to XML file
     */
    private void writeToFile(List<Member> dbList){
        try{
            db_write.writeToDB(dbList);
            updateDBFile();
        }catch(Exception e){ }
    }

}
