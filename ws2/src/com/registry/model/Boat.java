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

    private String length;
    private String type;
    private List<String> permittedBoatTypes = Arrays.asList(
            "Kayak/Canoe", "Sailboat", "Motorsailer", "Other"
    );


    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
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
