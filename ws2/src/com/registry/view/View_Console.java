package com.registry.view;

import com.registry.model.M_dbControl;

import java.util.Scanner;

public class View_Console {

    public M_dbControl DBHandle;
    private View_inputControl v;
    private View_strings helperStrings = new View_strings();
    //private View_inputControl v = new View_inputControl();
    private final Scanner scan = new Scanner(System.in);
    private String c;



    public View_Console(M_dbControl db){
        DBHandle = db;
        v = new View_inputControl(db, helperStrings, this);
        //start();
    }
    public String popInput(){
        helperStrings.getMainMessage();
        c = scan.nextLine();
        return c;
    }
    public void getInput(){
        String c = popInput();

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
