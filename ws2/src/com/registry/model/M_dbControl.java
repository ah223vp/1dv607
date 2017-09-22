package com.registry.model;

import java.util.ArrayList;
import java.util.List;

public class M_dbControl {

    private String dbFile = "src/com/registry/model/db.xml";
    private M_dbReader db_read = new M_dbReader(dbFile);
    private M_dbWriter db_write = new M_dbWriter(dbFile);
    private List<Member> dbList;

    public M_dbControl(){
        dbList = db_read.readFromDB(dbFile);
    }
    public Boolean memberExists(int id){
        for(Member member : dbList){
            int temp = Integer.parseInt(member.getM_id());
            if(temp == id){
                return true;
            }
        }
        return false;
    }
    private void updateDbFile(){
        dbList = db_read.readFromDB(dbFile);
    }
    public List<Member> listMembers(){
        return dbList;
    }
    public Member listMember(int memberId){
        return getMember(memberId);
    }
    public void addMember(String name, String p_number){
        Member i = new Member();
        i.setName(name);
        i.setP_number(p_number);
        i.setM_id(Integer.toString((int)Math.round(Math.random() * 1000)));
        dbList.add(i);
        writeToDB(dbList);
    }
    public void deleteBoat(int id, int boatIndex){
        Member member = getMember(id);
        member.removeBoat(boatIndex);
        writeToDB(dbList);
    }
    public void changeBoatInfo(int id, int index, String type, String length){
        Member member = getMember(id);
        member.getBoats().get(index).setLength(length);
        member.getBoats().get(index).setType(type);
        writeToDB(dbList);
    }
    public ArrayList<Boat> getBoatsForMember(int id){
        Member member = getMember(id);
        return member.getBoats();
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
    public void addBoat(int id, String type, String length){
        Member member = getMember(id);

        member.addBoat(type, length);

        writeToDB(dbList);
    }
    public List<String> getPermittedTypes(int id){
        Member member = getMember(id);
        return member.getPermittedTypes();
    }
    public void deleteMember(int memberId){
        List<Member> list;
        list = listMembers();

        for (Member i : list){
            if(Integer.parseInt(i.getM_id()) == memberId){
                list.remove(i);
                writeToDB(list);
                break;
            }
        }
    }
    private void writeToDB(List<Member> list){
        try{
            db_write.writeToDB(list);
            updateDbFile();
        }catch(Exception e){ }
    }
}
