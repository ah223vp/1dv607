package com.registry.model;

import java.util.ArrayList;
import java.util.List;

public interface IDBControl {

    List<Member>getMembers();
    void saveMember();
    void addMember(Member member);
    Member getMember(int id);
    boolean memberExists(int id);
    void deleteMember(Member member);




}
