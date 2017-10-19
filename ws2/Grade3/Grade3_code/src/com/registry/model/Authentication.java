package com.registry.model;

import javax.naming.AuthenticationException;
import java.nio.file.AccessDeniedException;
import java.util.Arrays;
import java.util.List;

public class Authentication {

    public enum Users{
        ADMIN, USER
    }

    public enum Actions{
        CHANGE, ADD, DELETE, LOOK, LIST, SEARCH

    }

    private List<Actions> deniedActions = Arrays.asList(Actions.ADD, Actions.CHANGE, Actions.DELETE);

    // HardCoded Credentials for now, could easily be swapped for DB call or something.
    private String username = "admin";
    private String password = "admin";

    public Users verifyLogin(String username, String password) throws AuthenticationException{
        if(username.equals(this.username) && password.equals(this.password)){
            return Users.ADMIN;
        }else
            throw new AuthenticationException();
    }
    public Users verifyLogout(Users user) throws Exception{
        if(user == Users.USER ){
            throw new Exception("Logout not possible");
        }else {
            return Users.USER;
        }
    }
    public boolean checkPermission(Users user, Actions action) throws AccessDeniedException{
        if(user == Users.USER){
            for(Actions a : deniedActions){
                // Really bad, change later
                if(a == action){
                    throw new AccessDeniedException("Access Denied");
                }
            }
        }
        return true;
    }

}
