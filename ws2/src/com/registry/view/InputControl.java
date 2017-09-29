package com.registry.view;


import com.registry.model.DBControl;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class for the input actions.
 * Calls are being made to the DB form here "DB".
 */
public class InputControl {

    private final Scanner scan = new Scanner(System.in);
    private IPrintStrings print;
    private DBControl m_DB;
    private Console console;

    public InputControl(DBControl m_DB, Console console, IPrintStrings print){
        this.print = print;
        this.console = console;
        this.m_DB = m_DB;
    }

    // Member methods
    public void listMembers(String str){
        if (str.equals("v")) {
            List members = m_DB.listMembersVerbose();
            for(Object member : members){
                System.out.println(member);
            }
        }else {
            for(Object i : m_DB.listMembersCompact()){
                System.out.println(i);
            }
        }
    }
    public void listMember(){
        print.displaySeeMemberMsg();
        int id = getID();

        System.out.println(m_DB.listMember(id));

    }
    public void deleteMember(){
        print.displayDeleteMessage();
        int id = getID();

        m_DB.deleteMember(id);
        print.displayMemberRemovedMsg();
    }
    public void addMember(){
        int id = -1;
        getMemberInfo(id);
    }
    public void changeMemberInfo(){
        print.displayChangeMessage();
        int id = getID();
        getMemberInfo(id);
    }

    // Boat Methods
    public void addBoat(){
        print.displayChangeMessage();
        int id = getID();
        String type = selectBoatType(id);
        print.displayBoatLengthMsg();
        String length = scan.nextLine();
        if(length.equals("") || length.equals("0")){
            print.errorLength();
            return;
        }
        m_DB.addBoat(id, type, length);
    }
    public void deleteBoat(){
        print.displayDeleteMessageBoat();
        int id = getID();

        int index = getBoats(id);
        m_DB.deleteBoat(id, index);

    }
    public void changeBoatInfo(){
        print.displayChangeMessage();
        int id = getID();

        int index = getBoats(id);
        String type = selectBoatType(id);
        print.displayBoatLengthMsg();
        String length = scan.nextLine();
        if(length.equals("0")){
            print.errorLength();
            return;
        }
        m_DB.changeBoatInfo(id, index, type, length);
    }


    // Helper methods below
    private int getBoats(int id){
        ArrayList boats = m_DB.getBoatsForMember(id);
        if(boats.size() == 0){
            print.errorUserHasNoBoats();
            console.getInput();
        }
        print.printBoats(boats);
        print.displayBoatNmrMsg();
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
            print.errorIntInput();
            scan.nextLine();
            console.getInput();
        }
        return index;
    }
    private String selectBoatType(int id){

        for(int i = 0; i < m_DB.getPermittedBoatTypes(id).size(); i++){
            System.out.print(i);
            print.displayIsEqualMsg();
            System.out.print(m_DB.getPermittedBoatTypes(id).get(i));
            System.out.println();
        }
        print.displayBoatTypeMsg();
        int num = validateBoatInput();
        validateIndex(m_DB.getPermittedBoatTypes(id), num);

        String type = m_DB.getPermittedBoatTypes(id).get(num);
        return type;

    }
    private void getMemberInfo(int id){

        print.displayNameMsg();
        String name = scan.nextLine();

        print.displayP_NumberMsg();
        String p_number = scan.nextLine();
        if(id != -1){
            m_DB.changeMemberInfo(id, name, p_number);
        }else {
            m_DB.addMember(name, p_number);
        }
    }
    private int getID(){
        int id = -1;
        try{
            id = scan.nextInt();
            scan.nextLine();
            if(m_DB.memberExists(id)){
                return id;
            }else {
                print.errorMemberNoeExistMsg();
                console.getInput();
            }

        }catch(Exception e){
            scan.nextLine();
            print.errorIntInput();
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
            print.errorIndex();
            console.getInput();
        }
    }
}
