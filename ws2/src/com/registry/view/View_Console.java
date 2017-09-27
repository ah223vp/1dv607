package com.registry.view;

import com.registry.model.M_dbControl;

import java.util.Scanner;

/**
 * Main class for the UI part.
 * Will be used for authentication, hence being small.
 */
public class View_Console {

    private M_dbControl DBHandle;
    private View_inputControl v;
    private View_strings helperStrings = new View_strings();
    private String c;

    private final Scanner scan = new Scanner(System.in);


    public View_Console(M_dbControl db){
        DBHandle = db;
        v = new View_inputControl(DBHandle, helperStrings, this);
    }
    private String popInput(){
        helperStrings.getMainMessage();
        c = scan.nextLine();
        return c;
    }
    public void getInput(){
        c = popInput();

        if (c.equals("list -v")) {
            v.listMembers("v");
        } else if (c.equals("list -c")) {
            v.listMembers("c");
        } else if (c.equals("add -m")) {
            v.addMember();
        } else if(c.equals("add -b")){
            v.addBoat();
        } else if (c.equals("delete -m")) {
            v.deleteMember();
        } else if (c.equals("delete -b")){
            v.deleteBoat();
        } else if (c.equals("look")) {
            v.listMember();
        } else if (c.equals("change -m")) {
            v.changeMemberInfo();
        } else if (c.equals("change -b")) {
            v.changeBoatInfo();
        } else if (c.equals("quit")) {
            System.exit(0);
        } else {
            v.helperStrings.getHelp_msg();
        }
        getInput();
    }



}
