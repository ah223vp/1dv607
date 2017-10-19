package com.registry.view;

import com.registry.model.Authentication;

import java.nio.file.AccessDeniedException;
import java.util.Scanner;

public class AuthenticationActions {

    // Current logged in user
    private Authentication.Users user;

    // Model auth class
    private Authentication auth;

    public AuthenticationActions(Authentication auth){
        this.user = Authentication.Users.USER;
        this.auth = auth;
    }

    public Authentication.Users getUser(){
        return this.user;
    }

    public void loginAttempt(){
        Scanner scan = new Scanner(System.in);

        System.out.print("Username: ");
        String username = scan.nextLine();

        System.out.print("Password: ");
        String password = scan.nextLine();

        // Maybe switch from exceptions to simply just return true or false.
        // The setting can´t happen in the model then, maybe makes more sence to have it in the view.
        try{
            this.user = this.auth.verifyLogin(username, password);
            System.out.println("Logging in: " + this.user);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void logoutAttempt() {

        try {
            this.user = auth.verifyLogout(this.user);
            System.out.println("Logging out: " + this.user);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * Called for every command to see if the current user is allowed to perform action.
     * The decision lies in the model. The view sends what type of action it wants to perform.
     * @param action Type of action it want to perform
     * @return Either true or catches exception from model.
     */
    public boolean checkPermission(Authentication.Actions action){
        try{
            if(auth.checkPermission(this.user, action)){
                return true;
            }
        }catch(AccessDeniedException e){
            System.out.println(e);
        }
        return false;
    }
}
