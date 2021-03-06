package com.registry.view;

import com.registry.model.IDBControl;


import java.util.Scanner;

public class InputControl implements IInputObserver {

    private Scanner scan = new Scanner(System.in);
    private String c;
    private MemberActions memberActions;
    private BoatActions boatActions;
    private ISystemPrintStrings print_system;

    public InputControl(IDBControl m_DB){
        this.memberActions = new MemberActions(m_DB, this);
        this.boatActions = new BoatActions(this.memberActions, m_DB, this);
        this.print_system = new SystemPrintStrings_eng();
        System.out.println(this.print_system.getWelcomeMessage());
    }

    private String populateInput(){
        System.out.print(print_system.getMainMessage());
        c = scan.nextLine();
        return c;
    }

    /**
     * Main part for the command handling.
     */
    public void getInput(){
        c = populateInput();

        // Add commands here, search login logout
        if (c.equals("list -v")) {
            memberActions.displayMembers("v");
        } else if (c.equals("list -c")) {
            memberActions.displayMembers("c");
        } else if (c.equals("add -m")) {
            memberActions.addMember();
        } else if(c.equals("add -b")){
            boatActions.addBoat();
        } else if (c.equals("delete -m")) {
            memberActions.deleteMember();
        } else if (c.equals("delete -b")){
            boatActions.deleteBoat();
        } else if (c.equals("look")) {
            memberActions.displayMember();
        } else if (c.equals("change -m")) {
            memberActions.changeMemberInfo();
        } else if (c.equals("change -b")) {
            boatActions.changeBoatInfo();
        } else if (c.equals("quit")) {
            System.exit(0);
        } else {
            System.out.println(print_system.getHelpMessage());
        }
        getInput();
    }

    /**
     * The observer uses this to call getinput instead of having a circular dependency like before.
     */
    public void notified(){
        getInput();
    }

}
