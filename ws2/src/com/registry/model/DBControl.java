package com.registry.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to interact with the DB, all methods exist in this class.
 * @dbFile The file representing the Database.
 * dbList is updated after every write method has been called.
 */
public class DBControl implements IDBControl{

    private String dbFile = "src/com/registry/db.xml"; // File for debugging
    //private String dbFile = "./db.xml"; // File for .jar
    private DBReader db_read = new DBReader(dbFile);
    private DBWriter db_write = new DBWriter(dbFile);
    private List<Member> dbList;

    public DBControl(){
        dbList = db_read.readFromDB(dbFile);
    }
    
    // Member methods
    public Boolean memberExists(int id){
        for(Member member : dbList){
            int temp = Integer.parseInt(member.getM_id());
            if(temp == id){
                return true;
            }
        }
        return false;
    }
    public List<Member> listMembersVerbose(){
        return dbList;
    }
    public List listMembersCompact(){
        List<String> list = new ArrayList<>();
        for(Member m : dbList){
            list.add(m.compactList());
        }
        return list;
    }
    public Member listMember(int memberId){
        return getMember(memberId);
    }
    public void addMember(String name, String p_number){
        Member i = new Member();
        i.setName(name);
        i.setP_number(p_number);
        // The setM_id can be made a million times better but for this app I think
        //it is sufficient
        i.setM_id(Integer.toString((int)Math.round(Math.random() * 1000)));
        dbList.add(i);
        writeToDB(dbList);
    }
    public void changeMemberInfo(int memberId, String name, String p_number){
        Member member = getMember(memberId);
        if(!name.equals("")){
            member.setName(name);
        }
        if(!p_number.equals("")){
            member.setP_number(p_number);
        }
        writeToDB(dbList);
    }
    public void deleteMember(int memberId){
        List<Member> list;
        list = listMembersVerbose();

        for (Member i : list){
            if(Integer.parseInt(i.getM_id()) == memberId){
                list.remove(i);
                writeToDB(list);
                break;
            }
        }
    }

    // Boat Methods
    public void addBoat(int id, String type, String length){
        Member member = getMember(id);

        member.addBoat(type, length);

        writeToDB(dbList);
    }
    public void changeBoatInfo(int id, int index, String type, String length){
        Member member = getMember(id);
        member.getBoats().get(index).setLength(length);
        member.getBoats().get(index).setType(type);
        writeToDB(dbList);
    }
    public void deleteBoat(int id, int boatIndex){
        Member member = getMember(id);
        member.removeBoat(boatIndex);
        writeToDB(dbList);
    }
    public ArrayList<Boat> getBoatsForMember(int id){
        Member member = getMember(id);
        return member.getBoats();
    }
    public List<String> getPermittedBoatTypes(int id){
        Member member = getMember(id);
        return member.getPermittedTypes();
    }


    // Private methods below here.
    private Member getMember(int id){
        Member member = null;
        for(Member item : dbList){
            int temp = Integer.parseInt(item.getM_id());
            if(temp == id){
                member = item;
            }
        }
        return member;
    }
    private void updateDbFile(){
        dbList = db_read.readFromDB(dbFile);
    }
    private void writeToDB(List<Member> list){
        try{
            db_write.writeToDB(list);
            updateDbFile();
        }catch(Exception e){ }
    }
}
