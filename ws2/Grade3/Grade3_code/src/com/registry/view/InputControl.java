package com.registry.view;

import com.registry.model.Authentication;
import com.registry.model.IDBControl;


import java.nio.file.AccessDeniedException;
import java.util.Scanner;

public class InputControl implements IInputObserver {

    private Scanner scan = new Scanner(System.in);
    private String c;
    private MemberActions memberActions;
    private BoatActions boatActions;
    private ISystemPrintStrings print_system;

    private AuthenticationActions auth;


    public InputControl(IDBControl m_DB, Authentication auth) {
        IMediator med = new Mediator();
        this.auth = new AuthenticationActions(auth);
        this.memberActions = new MemberActions(m_DB, this, med);
        this.boatActions = new BoatActions(this.memberActions, m_DB, this);
        this.print_system = new SystemPrintStrings_eng();
        System.out.println(this.print_system.getWelcomeMessage());
    }

    private String populateInput() {
        System.out.print("(" + this.auth.getUser() + ")" + print_system.getMainMessage());
        c = scan.nextLine();
        return c;
    }

    /**
     * Main part for the command handling.
     * The commands are connected to a type of action. This type decides
     * if the command is allowed or not. The model decides this.
     * If there is tine I will rewrite the input handling to make this prettier.
     */
    public void getInput() {
        c = populateInput();

        // Add commands here, search login logout
        if (c.equals("list -v")) {
            if (this.auth.checkPermission(Authentication.Actions.LIST)) {
                memberActions.displayMembers("v");
            }
        } else if (c.equals("list -c")) {
            if (this.auth.checkPermission(Authentication.Actions.LIST)) {
                memberActions.displayMembers("c");
            }
        } else if (c.equals("add -m")) {
            if (this.auth.checkPermission(Authentication.Actions.ADD)) {
                memberActions.addMember();
            }
        } else if (c.equals("add -b")) {
            if (this.auth.checkPermission(Authentication.Actions.ADD)) {
                boatActions.addBoat();
            }
        } else if (c.equals("delete -m")) {
            if (this.auth.checkPermission(Authentication.Actions.DELETE)) {
                memberActions.deleteMember();
            }
        } else if (c.equals("delete -b")) {
            if (this.auth.checkPermission(Authentication.Actions.DELETE)) {
                boatActions.deleteBoat();
            }
        } else if (c.equals("look")) {
            if (this.auth.checkPermission(Authentication.Actions.LOOK)) {
                memberActions.displayMember();
            }
        } else if (c.equals("change -m")) {
            if (this.auth.checkPermission(Authentication.Actions.CHANGE)) {
                memberActions.changeMemberInfo();
            }
        } else if (c.equals("change -b")) {
            if (this.auth.checkPermission(Authentication.Actions.CHANGE)) {
                boatActions.changeBoatInfo();
            }
        } else if (c.equals("search")){
            if(this.auth.checkPermission(Authentication.Actions.SEARCH)){
                memberActions.search();
            }
        } else if(c.equals("login")){
            this.auth.loginAttempt();
        } else if(c.equals("logout")){
            this.auth.logoutAttempt();
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
