package com.registry.model;



import java.util.List;

public class DBControl2 implements IDBControl {

    private String dbFile = "src/com/registry/db2.xml"; // File for debugging
    //private String dbFile = "./db.xml"; // File for .jar
    private DBReader db_read = new DBReader(dbFile);
    private DBWriter db_write = new DBWriter(dbFile);

    private List<Member> dbList;

    public DBControl2(){
        dbList = db_read.readFromDB(dbFile);
    }

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
    private void updateDBFile(){
        dbList = db_read.readFromDB(dbFile);
    }
    private void writeToFile(List<Member> dbList){
        try{
            db_write.writeToDB(dbList);
            updateDBFile();
        }catch(Exception e){ }
    }

}
