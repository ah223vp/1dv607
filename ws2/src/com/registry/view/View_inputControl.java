package com.registry.view;


import com.registry.model.M_dbControl;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class for the input actions.
 * Calls are being made to the DB form here "DB".
 */
public class View_inputControl {

    private final Scanner scan = new Scanner(System.in);
    public View_strings helperStrings;
    private M_dbControl db;
    private View_Console console;

    public View_inputControl(M_dbControl xml_db, View_strings help, View_Console v){
        console = v;
        helperStrings = help;
        db = xml_db;
    }

    public void listMembers(String str){
        List members = db.listMembersVerbose();
        if (str.equals("v")) {
            for(Object member : members){
                System.out.println(member);
            }
        }else {
            for(Object i : db.listMembersCompact()){
                System.out.println(i);
            }
        }
    }
    public void listMember(){
        helperStrings.displaySeeMemberMsg();
        int id = getID();

        System.out.println(db.listMember(id));

    }
    public void deleteMember(){
        helperStrings.displayDeleteMessage();
        int id = getID();

        db.deleteMember(id);
        System.out.println("Member Removed");
    }
    public void addMember(){
        int id = -1;
        getMemberInfo(id);
    }
    public void changeMemberInfo(){
        helperStrings.displayChangeMessage();
        int id = getID();
        getMemberInfo(id);
    }

    public void addBoat(){
        helperStrings.displayChangeMessage();
        int id = getID();
        String type = selectBoatType(id);
        System.out.print("Boat length: ");
        String length = scan.nextLine();
        if(length.equals("") || length.equals("0")){
            System.out.println("Length must be specified");
            return;
        }
        db.addBoat(id, type, length);
    }
    public void deleteBoat(){
        helperStrings.displayDeleteMessageBoat();
        int id = getID();

        int index = getBoats(id);
        db.deleteBoat(id, index);

    }
    public void changeBoatInfo(){
        helperStrings.displayChangeMessage();
        int id = getID();

        int index = getBoats(id);
        String type = selectBoatType(id);
        System.out.print("Boat length: ");
        String length = scan.nextLine();
        if(length.equals("0")){
            System.out.println("Length is not allowed to be 0");
            return;
        }
        db.changeBoatInfo(id, index, type, length);
    }


    // Helper methods below
    private int getBoats(int id){
        ArrayList boats = db.getBoatsForMember(id);
        helperStrings.printBoats(boats);
        System.out.print("Boat number: ");
        int index = validateBoatInput();

        validateIndex(boats, index);
        return index;
    }
    private int validateBoatInput(){
        int index = -1;
        try{
            index = scan.nextInt();
            scan.nextLine();
        }catch(Exception e){
            System.out.println("Only ints");
            scan.nextLine();
            console.getInput();
        }
        return index;
    }
    private String selectBoatType(int id){

        for(int i = 0; i < db.getPermittedTypes(id).size(); i++){
            System.out.println(i + " is equal to type: " + db.getPermittedTypes(id).get(i));
        }
        System.out.print("Type number: ");
        int num = validateBoatInput();
        validateIndex(db.getPermittedTypes(id), num);

        String type = db.getPermittedTypes(id).get(num);
        return type;

    }
    private void getMemberInfo(int id){

        System.out.print("Name: ");
        String name = scan.nextLine();

        System.out.print("Personal Number: ");
        String p_number = scan.nextLine();
        if(id != -1){
            db.changeMemberInfo(id, name, p_number);
        }else {
            db.addMember(name, p_number);
        }
    }
    private int getID(){
        int id = -1;
        try{
            id = scan.nextInt();
            scan.nextLine();
            if(db.memberExists(id)){
                return id;
            }else {
                helperStrings.displayMemberNoeExistMsg();
                console.getInput();
            }

        }catch(Exception e){
            scan.nextLine();
            System.out.println("Only integers allowed");
            console.getInput();
        }
        return id;
    }
    private void validateIndex(List array, int index){
        try{
            if(index < 0 || index > array.size()-1){
                throw new Exception();
            }
        }catch(Exception e){
            System.out.println("Index not allowed");
            console.getInput();
        }
    }
}
