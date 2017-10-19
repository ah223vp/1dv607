package com.registry.view;

import com.registry.model.IDBControl;
import com.registry.model.Member;

import java.util.List;
import java.util.Scanner;

public class Mediator implements IMediator {

    private IDBControl m_db;

    public List<Member> search(String typeOfSearch){
        Scanner scan = new Scanner(System.in);

        System.out.print("Searchstring: ");
        String c = scan.nextLine();

        String type = "NAME";

        return m_db.search(c, type);
    }

    public void registerDB(IDBControl m_db){
        this.m_db = m_db;
    }
}
