package com.registry;


import com.registry.model.DBControl;
import com.registry.model.DBControl2;
import com.registry.model.IDBControl;
import com.registry.view.Console;

public class Main {

    public static void main(String[] args) {


        /**
         * GÖR OM SÅ ATT DU ENBART JOBBAR MED MEMBER OBJEKT I VIEW!!!!!!!
         */

        //IDBControl xC = new DBControl();
        DBControl2 xC = new DBControl2();
        Console vC = new Console(xC);
        vC.getInput();

    }
}
