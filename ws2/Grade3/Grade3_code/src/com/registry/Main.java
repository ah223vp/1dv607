package com.registry;


import com.registry.model.Authentication;
import com.registry.model.DBControl;
import com.registry.model.IDBControl;
import com.registry.view.InputControl;

public class Main {

    public static void main(String[] args) {

        // Starting point to the application. Run this file to compile the project.

        IDBControl iDB = new DBControl();

        Authentication au = new Authentication();

        InputControl iC = new InputControl(iDB, au);



        iC.getInput();

    }
}
