package com.registry.view;


import com.registry.model.IDBControl;

import java.util.Scanner;

/**
 * Main class for the UI part.
 * Will be used for authentication, hence being small.
 */
public class Console {

    private InputControl2 inputControl;
    private IPrintStrings print;
    private String c;

    private final Scanner scan = new Scanner(System.in);

    public Console(IDBControl db){
        print = new PrintStrings_eng();
        inputControl = new InputControl2(db, this, print);
    }
    private String populateInput(){
        print.getMainMessage();
        c = scan.nextLine();
        return c;
    }
    public void getInput(){
        c = populateInput();

        // Add commands here, search login logout
        if (c.equals("list -v")) {
            inputControl.displayMembers("v");
        } else if (c.equals("list -c")) {
            inputControl.displayMembers("c");
        } else if (c.equals("add -m")) {
            inputControl.addMember();
        } else if(c.equals("add -b")){
            inputControl.addBoat();
        } else if (c.equals("delete -m")) {
            inputControl.deleteMember();
        } else if (c.equals("delete -b")){
            inputControl.deleteBoat();
        } else if (c.equals("look")) {
            inputControl.displayMember();
        } else if (c.equals("change -m")) {
            inputControl.changeMemberInfo();
        } else if (c.equals("change -b")) {
            inputControl.changeBoatInfo();
        } else if (c.equals("quit")) {
            System.exit(0);
        } else {
            print.getHelp_msg();
        }
        getInput();
    }



}
