package com.registry;


import com.registry.model.DBControl;
import com.registry.model.IDBControl;
import com.registry.view.Console;

public class Main {

    public static void main(String[] args) {



        IDBControl xC = new DBControl();
        Console vC = new Console(xC);
        vC.getInput();

    }
}
