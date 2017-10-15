package com.registry.model;

import java.util.Arrays;
import java.util.List;

/**
 * Representing a boat that the member can have. Is used for
 * input handling and when reading/writing form the DB.
 * Handling the type setting is done from here.
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

    /**
     * Setting the length of the boat. Basic error handling to make sure the type is valid.
     * @param length the boat should have.
     * @return boolean depending on the input.
     */
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

    /**
     * Setting the type of boat. Basic error handling to make sure the type is valid.
     * @param type to set
     * @return boolean if the input is valid or not.
     */
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
