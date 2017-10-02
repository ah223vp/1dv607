package com.registry.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Representing a boat that the member can have. Is used for
 * input handling and when reading/writing form the DB.
 * Custom toString for easier printouts.
 */
public class Boat {

    private double length;
    private String type;
    private List<String> permittedBoatTypes = Arrays.asList(
            "Kayak/Canoe", "Sailboat", "Motorsailer", "Other"
    );


    public Double getLength() {
        return length;
    }

    public Boolean setLength(double length) {

        if(this.length == 0 && length == -1 ){
            return false;
        }else {
            if(length == -1 || length <= 0){

            }else {
                this.length = length;
            }
            return true;
        }

    }
    public String getType() {
        return type;
    }


    public Boolean setType(String type) {

        if(this.type == null && type.length() == 0){
            // Keeps addMember from inputting empty field.
            return false;
        }else {
            if(type.length() == 0){
                // Do nothing and keep name the same.
            }else {
                this.type = type;
            }
            return true;

        }
    }
     public List<String> getPermittedBoatTypes(){
        return permittedBoatTypes;
     }


}
