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

    //private IDBControl m_DB;
    private Authentication auth;

    private Authentication.Actions actions;

    private Authentication.Users user;

    public InputControl(IDBControl m_DB, Authentication auth) {
        //this.m_DB = m_DB;

        IMediator med = new Mediator();
        this.auth = auth;
        this.memberActions = new MemberActions(m_DB, this, med);
        this.boatActions = new BoatActions(this.memberActions, m_DB, this);
        this.print_system = new SystemPrintStrings_eng();
        this.user = Authentication.Users.USER;
        System.out.println(this.print_system.getWelcomeMessage());
    }

    private String populateInput() {
        System.out.print("(" + this.user + ")" + print_system.getMainMessage());
        c = scan.nextLine();
        return c;
    }

    /**
     * Main part for the command handling.
     */
    public void getInput() {
        c = populateInput();

        // Add commands here, search login logout
        if (c.equals("list -v")) {
            if (checkPermission(this.user, Authentication.Actions.LIST)) {
                memberActions.displayMembers("v");
            }
        } else if (c.equals("list -c")) {
            if (checkPermission(this.user, Authentication.Actions.LIST)) {
                memberActions.displayMembers("c");
            }
        } else if (c.equals("add -m")) {
            if (checkPermission(this.user, Authentication.Actions.ADD)) {
                memberActions.addMember();
            }
        } else if (c.equals("add -b")) {
            if (checkPermission(this.user, Authentication.Actions.ADD)) {
                boatActions.addBoat();
            }
        } else if (c.equals("delete -m")) {
            if (checkPermission(this.user, Authentication.Actions.DELETE)) {
                memberActions.deleteMember();
            }
        } else if (c.equals("delete -b")) {
            if (checkPermission(this.user, Authentication.Actions.DELETE)) {
                boatActions.deleteBoat();
            }
        } else if (c.equals("look")) {
            if (checkPermission(this.user, Authentication.Actions.LOOK)) {
                memberActions.displayMember();
            }
        } else if (c.equals("change -m")) {
            if (checkPermission(this.user, Authentication.Actions.CHANGE)) {
                memberActions.changeMemberInfo();
            }
        } else if (c.equals("change -b")) {
            if (checkPermission(this.user, Authentication.Actions.CHANGE)) {
                boatActions.changeBoatInfo();
            }
        } else if (c.equals("search")){
            if(checkPermission(this.user, Authentication.Actions.SEARCH)){
                memberActions.search();
            }
        } else if(c.equals("login")){
            loginAttempt();
        } else if(c.equals("logout")){
            logoutAttempt();
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

    private void loginAttempt(){
        System.out.print("Username: ");
        String username = scan.nextLine();

        System.out.print("Password: ");
        String password = scan.nextLine();

        try{
            this.user = this.auth.verifyLogin(username, password);
            System.out.println("Logging in: " + this.user);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private void logoutAttempt() {

        try {
            this.user = auth.verifyLogout(this.user);
            System.out.println("Logging out: " + this.user);
        } catch (Exception e){
            System.out.println(e);
        }

    }

    private boolean checkPermission(Authentication.Users user, Authentication.Actions action){
        try{
            if(auth.checkPermission(user, action)){
                return true;
            }
        }catch(AccessDeniedException e){
            System.out.println(e);
        }
        return false;
    }

}
