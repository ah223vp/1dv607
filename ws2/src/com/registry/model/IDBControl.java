package com.registry.model;

import java.util.ArrayList;
import java.util.List;

public interface IDBControl {

    // Member methods
    Boolean memberExists(int id);
    List listMembersVerbose();
    List listMembersCompact();
    Member listMember(int id);
    void addMember(String name, String p_number);
    void changeMemberInfo(int id, String name, String p_number);
    void deleteMember(int id);


    // Boat Methods
    void addBoat(int id, String type, String length);
    void changeBoatInfo(int id,int index, String type, String length);
    void deleteBoat(int id, int boatIndex);
    ArrayList getBoatsForMember(int id);
    List<String> getPermittedBoatTypes(int id);


}
