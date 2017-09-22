package com.registry;


import com.registry.model.M_dbControl;
import com.registry.view.View_Console;

public class Main {

    public static void main(String[] args) {



        M_dbControl xC = new M_dbControl();
        View_Console vC = new View_Console(xC);
        vC.getInput();

    }
}
