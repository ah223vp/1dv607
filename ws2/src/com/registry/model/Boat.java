package com.registry.model;


public class Boat {
    private String length;

    private String type;


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

    @Override
    public String toString(){
        return "[" + type + " , " + length + " m" + "]";
    }
}