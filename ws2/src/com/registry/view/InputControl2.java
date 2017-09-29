package com.registry.view;

import com.registry.model.Boat;
import com.registry.model.DBControl2;
import com.registry.model.IDBControl;
import com.registry.model.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputControl2 {

    private final Scanner scan = new Scanner(System.in);
    private IPrintStrings print;
    //private IDBControl m_DB;
    private DBControl2 m_DB;
    private Console console;

    public InputControl2(IDBControl m_DB, Console console, IPrintStrings print){
        this.print = print;
        this.console = console;
        this.m_DB = m_DB;
    }

    // Member methods
    public void deleteMember(){
        Member member = getMember();
        m_DB.deleteMember(member);
    }
    public void addMember(){
        Member member = new Member();
        member = getMemberInfo(member);
        m_DB.addMember(member);
    }
    public void changeMemberInfo(){
        Member member = getMember();
        getMemberInfo(member);
        m_DB.saveMember(member);
    }

    // Boat Methods
    public void addBoat(){
        Member member = getMember();
        Boat boat = new Boat();
        String type = selectBoatType(boat);
        boat.setType(type);
        print.displayBoatLengthMsg();
        Double length = scan.nextDouble();
        // change in dbControl.member.boat
        boat.setLength(length);
        member.addBoat(boat);
        m_DB.saveMember(member);
        // print types

    }
    public void deleteBoat(){
        print.displayDeleteMessageBoat();
        Member member = getMember();
        Boat boat = selectBoat(member);
        member.removeBoat(boat);
        m_DB.saveMember(member);
    }
    public void changeBoatInfo(){
        print.displayChangeMessage();
        Member member = getMember();

        Boat boat = selectBoat(member);
        String type = selectBoatType(boat);
        boat.setType(type);
        print.displayBoatLengthMsg();
        Double length = scan.nextDouble();

        // Cahnge later, input is String in boat
        boat.setLength(length);
        if(length.equals("0")){
            print.errorLength();
            return;
        }
        m_DB.saveMember(member);
    }

    // Private methods below
    private Member getMemberInfo(Member member){
        print.displayNameMsg();
        String name = scan.nextLine();
        member.setName(name);

        print.displayP_NumberMsg();
        String p_number = scan.nextLine();
        member.setP_number(p_number);
        return member;
    }
    private Member getMember(){
        int id = -1;
        try{
            id = scan.nextInt();
            scan.nextLine();
            if(m_DB.memberExists(id)){
                return m_DB.getMember();
            }else {
                print.errorMemberNoeExistMsg();
                console.getInput();
            }

        }catch(Exception e){
            scan.nextLine();
            print.errorIntInput();
            console.getInput();
        }
        //return member;
    }
    private Boat selectBoat(Member member){
        ArrayList boats = member.getBoats();
        if(boats.size() == 0){
            print.errorUserHasNoBoats();
            console.getInput();
        }
        print.printBoats(boats);
        print.displayBoatNmrMsg();
        int selection = validateBoatInput();

        validateIndex(boats, selection);
        return member.getBoats().get(selection);
    }
    private String selectBoatType(Boat boat){
        for(int i = 0; i < boat.getPermittedBoatTypes().size(); i++){
            System.out.print(i);
            print.displayIsEqualMsg();
            System.out.print(boat.getPermittedBoatTypes().get(i));
            System.out.println();
        }
        print.displayBoatTypeMsg();
        int selection = validateBoatInput();
        validateIndex(boat.getPermittedBoatTypes(), selection);

        String type = boat.getPermittedBoatTypes().get(selection);
        return type;
    }
    private int validateBoatInput(){
        int index = -1;
        try{
            index = scan.nextInt();
            scan.nextLine();
        }catch(Exception e){
            print.errorIntInput();
            scan.nextLine();
            console.getInput();
        }
        return index;
    }
    private void validateIndex(List array, int index){
        try{
            if(index < 0 || index > array.size()-1){
                throw new Exception();
            }
        }catch(Exception e){
            print.errorIndex();
            console.getInput();
        }
    }
}
