package com.registry.view;

import com.registry.model.IDBControl;

import java.util.List;
import java.util.Scanner;

public class Mediator implements IMediator {

    private IDBControl m_db;

    public List searchMembersByName(){
        Scanner scan = new Scanner(System.in);

        System.out.print("Searchstring: ");
        String c = scan.nextLine();

        return m_db.search(c);
    }

    public void registerDB(IDBControl m_db){
        this.m_db = m_db;
    }
}
