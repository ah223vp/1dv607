package com.registry.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Class representing a member of the clud.
 * Handles the printing of members and adding boats.
 */
public class Member {

    private String name;
    private int p_number;
    private int m_id;
    private String n_boats;
    private String type_boats;
    private ArrayList<Boat> boats = new ArrayList<Boat>();
    private int p_numberLength = 10;
    private List<String> permittedBoatTypes = Arrays.asList(
            "Kayak/Canoe", "Sailboat", "Motorsailer", "Other"
    );

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

    public void setN_boats(String n_boats) {
        this.n_boats = n_boats;
    }

    public String getType_boats() {
        return type_boats;
    }

    public void setBoatType(String type_boats) {
        this.type_boats = type_boats;
    }

    /**
     * Permitted types the user can select for a boat
     * @return Arraylist with permitted types
     */
    public List<String> getPermittedTypes(){
        return permittedBoatTypes;
    }

    public ArrayList<Boat> getBoats() {
        return boats;
    }

    public void addBoat(Boat boat){
        boats.add(boat);
    }

    /**
     * Adding new boat to the member
     * @param type Type of boat, user select from permittedBoattypes
     * @param length
     */
    public void addBoat(String type, Double length){
        Boat boat = new Boat();
        boat.setLength(length);
        boat.setType(type);
        boats.add(boat);
    }

    /**
     * Removes a boat from the member
     * @param boatIndex Index in the boatlist to remove, user selects
     */
    public void removeBoat(int boatIndex){
        boats.remove(boatIndex);
    }
    public void removeBoat(Boat boat){
        boats.remove(boat);
    }

}
