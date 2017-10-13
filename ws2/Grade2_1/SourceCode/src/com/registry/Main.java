package com.registry;


import com.registry.model.DBControl;
import com.registry.model.IDBControl;
import com.registry.view.Console;

public class Main {

    public static void main(String[] args) {

        // Starting point to the application. Run this file to compile the project.

        IDBControl xC = new DBControl();
        Console vC = new Console(xC);
        vC.getInput();

    }
}
