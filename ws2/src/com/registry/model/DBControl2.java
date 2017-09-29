package com.registry.model;

public class DBControl2 {

    public void saveMember(Member newMember){
        Member member = dbList.get(member);
        member = newMember;
        try{
            db_write.writeToDB(list);
            updateDbFile();
        }catch(Exception e){ }
    }

    public void addMember(Member member){
        dbList.add(member);
    }
    public Member getMember(int id){
        return member;
    }
    public void deleteMember(Member member){
        dbList.remove(member);
    }

}
