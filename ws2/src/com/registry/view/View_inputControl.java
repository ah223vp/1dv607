package com.registry.view;

import com.registry.model.Member;
import com.registry.model.M_dbControl;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class View_inputControl {

    private final Scanner scan = new Scanner(System.in);
    private String c;
    public View_strings helperStrings;
    private M_dbControl db;
    private View_Console console;

    public View_inputControl(M_dbControl xml_db, View_strings help, View_Console v){
       // scan = new Scanner(System.in);
        console = v;
        helperStrings = help;
        db = xml_db;
    }
    /*
    public String getInput(){
        helperStrings.getMainMessage();
        c = scan.nextLine();
        return c;
    }
    */
    public void listMembers(String str){
        List<Member> members = db.listMembers();

        if (str.equals("v")) {
            for(Member member : members){
                System.out.println(member);
            }
        }else {
            for(Member member : members){
                System.out.println(member.compactList());
            }
        }

    }
    public void listMember(){
        int id = getID();
        if(db.memberExists(id)){
            System.out.println(db.listMember(id));
        }else {
            helperStrings.displayMemberNoeExistMsg();
        }

    }
    public void deleteMember(){
        helperStrings.displayDeleteMessage();
        int id = getID();
        if(db.memberExists(id)){
            db.deleteMember(id);
            System.out.println("Member Removed");
        }else {
            helperStrings.displayMemberNoeExistMsg();
        }

    }
    public void addMember(){
        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.print("Personal Number: ");
        String p_number = scan.nextLine();
        db.addMember(name, p_number);
    }
    public void changeMemberInfo(){
        helperStrings.displayChangeMessage();
        int id = getID();
        if(db.memberExists(id)){
            System.out.print("Name: ");
            String name = scan.nextLine();
            System.out.print("Personal Number: ");
            String p_number = scan.nextLine();
            db.changeMemberInfo(id, name, p_number);
        }else {
            helperStrings.displayMemberNoeExistMsg();
        }
    }

    private int getID(){
        int id = -1;
        try{
            id = scan.nextInt();

            return id;
        }catch(Exception e){
            System.out.println("Only integers allowed");
        }
        return id;
    }

    public void addBoat(){
        helperStrings.displayChangeMessage();
        int id = getID();
        if(db.memberExists(id)){
            String type = selectBoatType(id);
            System.out.print("Boat length: ");
            String length = scan.nextLine();
            if(length.equals("") || length.equals("0")){
                System.out.println("Length must be specified");
                return;
            }
            db.addBoat(id, type, length);
        }else {
            helperStrings.displayMemberNoeExistMsg();
        }
    }
    public void deleteBoat(){
        helperStrings.displayDeleteMessageBoat();
        int id = getID();
        if(db.memberExists(id)){
            int index = getBoats(id);
            db.deleteBoat(id, index);
        }
    }
    public void changeBoatInfo(){
        helperStrings.displayChangeMessage();
        int id = getID();
        if(db.memberExists(id)){
            int index = getBoats(id);
            String type = selectBoatType(id);
            System.out.print("Boat length: ");
            String length = scan.nextLine();
            if(length.equals("0")){
                System.out.println("Length is not allowed to be 0");
                return;
            }
            db.changeBoatInfo(id, index, type, length);
        }else {
            helperStrings.displayMemberNoeExistMsg();
        }
    }
    private int getBoats(int id){
        ArrayList boats = db.getBoatsForMember(id);
        helperStrings.printBoats(boats);
        System.out.print("Boat number: ");
        //int index = scan.nextInt();
        int index = getID();
        validateIndex(boats, index);
        scan.nextLine();
        return index;
    }
    private String selectBoatType(int id){
        for(int i = 0; i < db.getPermittedTypes(id).size(); i++){
            System.out.println(i + " is equal to type: " + db.getPermittedTypes(id).get(i));
        }
        System.out.print("Type number: ");
        int num = getID();
        validateIndex(db.getPermittedTypes(id), num);
        scan.nextLine();
        String type = db.getPermittedTypes(id).get(num);
        return type;
    }
    private void validateIndex(List array, int index){
        try{
            if(index < 0 || index > array.size()){
                throw new Exception("Index of out bounds");
            }
        }catch(Exception e){
            System.out.println(e);
            scan.nextLine();
            console.getInput();
        }

    }
}
