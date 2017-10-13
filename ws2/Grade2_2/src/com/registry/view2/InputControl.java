package com.registry.view2;

import com.registry.model.IDBControl;


import java.util.Scanner;

public class InputControl implements IInputObserver {

    private Scanner scan = new Scanner(System.in);
    private String c;
    private MemberActions memberActions;
    private BoatActions boatActions;

    public InputControl(IDBControl m_DB){
        this.memberActions = new MemberActions(m_DB, this);
        this.boatActions = new BoatActions(this.memberActions, m_DB, this);
    }

    private String populateInput(){
        System.out.println("Command :");
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
            //print.getHelp_msg();
            System.out.print("HEEEEEEEEEELP");
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
