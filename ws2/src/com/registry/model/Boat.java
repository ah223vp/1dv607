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

    private Double length;
    private String type;
    private List<String> permittedBoatTypes = Arrays.asList(
            "Kayak/Canoe", "Sailboat", "Motorsailer", "Other"
    );


    public Double getLength() {
        return length;
    }

    public Boolean setLength(Double length) {
        if(length == 0 || length < 0){
            return false;
        }else {
            this.length = length;
            return true;
        }

    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }
     public List<String> getPermittedBoatTypes(){
        return permittedBoatTypes;
     }


    // Change this!!!!!!!!!!!!
    @Override
    public String toString(){
        return "[" + type + " , " + length + " m" + "]";
    }
}
