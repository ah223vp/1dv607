package com.registry.model;


import java.util.List;

public interface IDBControl {

    /**
     * Retrieves the member list object for handling
     * @return List with member objects
     */
    List<Member>getMembers();

    /**
     * Save method. Tells the "DB" to save the current DBFile
     */
    void saveMember();

    /**
     * Adding a member to dbList and then writing to the XML file
     * @param member to be added in the XML file and list
     */
    void addMember(Member member);

    /**
     * Returning a specific member object to the caller
     * @param id Member id to search the db upon
     * @return Member object to manipulate
     */
    Member getMember(int id);

    /**
     * Check to see if the member exists. Make error handling easier to have a "pre" check.
     * @param id id to search for
     * @return boolean depending on the user exists or not
     */
    boolean memberExists(int id);

    /**
     * Deleting a seleceted member from list and file
     * @param member to be deleted from list and file
     */
    void deleteMember(Member member);

    List<Member> search(Object obj, String type);






}
