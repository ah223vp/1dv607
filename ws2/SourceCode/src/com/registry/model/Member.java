package com.registry.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Class representing a member of the club.
 * Handles the members info and adding/removing
 */
public class Member {

    private String name;
    private int p_number;
    private int m_id;
    private String n_boats;
    private String type_boats;
    private ArrayList<Boat> boats = new ArrayList<Boat>();
    private int p_numberLength = 10;


    public String getName() {
        return name;
    }

    public Boolean setName(String name) {

        if(this.name == null && name.length() == 0){
            // Keeps addMember from inputting empty field.
            return false;
        }else {
            if(name.length() == 0){
                // Do nothing and keep name the same.
            }else {
                this.name = name;
            }
            return true;

        }
    }

    public int getP_number() {
        return p_number;
    }

    public Boolean setP_number(int p_number) {

        // Checking value and length of number for simple validation
        if(this.p_number == 0 && p_number == -1 || Integer.toString(p_number).length() < p_numberLength ||
                Integer.toString(p_number).length() > p_numberLength){
            // Keeps addMember from inputting empty field.
            return false;
        }else {

            if(p_number == -1 ){
                // Do nothing and keep name the same.
            }else {
                this.p_number = p_number;
            }
            return true;

        }
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getN_boats() {
        return Integer.toString(boats.size());
    }

    public Boat getBoatObject(){
        return new Boat();
    }

    public void setN_boats(String n_boats) {
        this.n_boats = n_boats;
    }

    public String getType_boats() {
        return type_boats;
    }

    public ArrayList<Boat> getBoats() {
        return boats;
    }

    /**
     * Adding a boat to the user
     * @param boat to be added
     */
    public void addBoat(Boat boat){
        boats.add(boat);
    }

    /**
     * Method is called from the db_reader class.
     * @param type
     * @param length
     */
    public void addBoat(String type, double length){
        Boat boat = new Boat();
        boat.setLength(length);
        boat.setType(type);
        boats.add(boat);
    }

    /**
     * Removes a boat from the member
     * @param  boat in the boatlist to remove
     */
    public void removeBoat(Boat boat){
        boats.remove(boat);
    }

}
