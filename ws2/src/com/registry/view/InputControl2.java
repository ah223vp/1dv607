package com.registry.view;

import com.registry.model.Boat;
import com.registry.model.IDBControl;
import com.registry.model.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputControl2 {

    private final Scanner scan = new Scanner(System.in);

    private IPrintStrings print;
    private IDBControl m_DB;
    private Console console;

    public InputControl2(IDBControl m_DB, Console console, IPrintStrings print){
        this.print = print;
        this.console = console;
        this.m_DB = m_DB;
    }

    // Member methods
    public void deleteMember(){
        print.displayDeleteMessage();
        Member member = getMember();
        m_DB.deleteMember(member);
    }
    public void addMember(){
        Member member = new Member();
        member = getMemberInfo(member);
        m_DB.addMember(member);
    }
    public void changeMemberInfo(){
        print.displayChangeMessage();
        Member member = getMember();
        getMemberInfo(member);
        m_DB.saveMember();
    }
    public void displayMember(){
        print.displaySeeMemberMsg();
        Member member = getMember();
        printMember(member);
    }
    public void displayMembers(String listType){
        if(listType.equals("v")){
            for(Member m : m_DB.getMembers()){
                printMember(m);
            }
        }else {
            for(Member m : m_DB.getMembers()){
                System.out.println("Member: " + m.getName() + " , " + "M_id =" + m.getM_id() + " , " + "NoBoats: " + m.getN_boats());
            }
        }

    }

    // Boat Methods
    public void addBoat(){
        print.displayChangeMessage();
        Member member = getMember();
        Boat boat = new Boat();
        String type = selectBoatType(boat);
       // boat.setType(type);
        print.displayBoatLengthMsg();
        Double length = getDoubleInput();

        if(!boat.setLength(length) || !boat.setType(type)){
            print.errorLength();
            return;
        }
        member.addBoat(boat);
        m_DB.saveMember();
        // print types

    }
    public void deleteBoat(){
        print.displayDeleteMessageBoat();
        Member member = getMember();
        Boat boat = selectBoat(member);
        member.removeBoat(boat);
        m_DB.saveMember();
    }
    public void changeBoatInfo(){
        print.displayChangeMessage();
        Member member = getMember();

        Boat boat = selectBoat(member);
        String type = selectBoatType(boat);

        print.displayBoatLengthMsg();
        Double length = getDoubleInput();

        if(!boat.setLength(length)){
            print.errorLength();
            return;
        }
        boat.setType(type);


        m_DB.saveMember();
    }

    // Private methods below
    private Member getMemberInfo(Member member){
        scan.reset();
        print.displayNameMsg();
        String name = scan.nextLine();
        //member.setName(name);
        print.displayP_NumberMsg();
        int p_number = getIntInput();
        //member.setP_number(p_number);
        if (!member.setName(name) || !member.setP_number(p_number)) {
            print.errorFaultyP_Number();
            console.getInput();
        }
        return member;
    }
    private Member getMember(){
        int id = -1;
       Member member = null;
        scan.useDelimiter("\n");
        try{
            id = scan.nextInt();
            scan.nextLine();

            if(m_DB.memberExists(id)){
                member = m_DB.getMember(id);
            }else {
                print.errorMemberNoeExistMsg();
                console.getInput();
            }

        }catch(Exception e){

            scan.nextLine();
            print.errorIntInput();
            console.getInput();
        }

        return member;
    }
    private Boat selectBoat(Member member){
        ArrayList boats = member.getBoats();
        if(boats.size() == 0){
            print.errorUserHasNoBoats();
            console.getInput();
        }
        print.printBoats(boats);
        print.displayBoatNmrMsg();
        int selection = getIntInput();

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
        int selection = getIntInput();
        validateIndex(boat.getPermittedBoatTypes(), selection);

        String type = boat.getPermittedBoatTypes().get(selection);
        return type;
    }
    private int getIntInput(){

        int index = -1;
        scan.useDelimiter("\n");
        try{
            index = scan.nextInt();
            scan.nextLine();
        }catch(Exception e){
           // scan.reset();
            print.errorIntInput();
            scan.nextLine();
            console.getInput();
        }
       // scan.reset();
        return index;
    }
    private void validateIndex(List array, int index){
        try{
            if(index < 0 || index > array.size()-1){
                throw new Exception();
            }
        }catch(Exception e){
            print.errorIndex();
            scan.nextLine();
            console.getInput();
        }
    }
    private Double getDoubleInput(){
        double dbl = -1;
        scan.useDelimiter("\n");
        try{
            dbl = scan.nextDouble();
            scan.nextLine();

        }catch(Exception e){
           // scan.reset();
            scan.nextLine();
            if(dbl == -1){
                return dbl;
            }

            print.errorDoubleInput();
            console.getInput();
        }
        //scan.reset();
        return dbl;
    }
    private void printMember(Member member){

        System.out.print("Member: " + member.getName() + "\n"+ "\t" + "Info: " +"SocialSecNum = " + member.getP_number()
                + ", M_id = " + member.getM_id() + "\n" + "\t" + "Boats(" + member.getN_boats() +"): ");
        for(Boat b : member.getBoats()){
            System.out.print(" |" + b.getType() + " , " + b.getLength() +" m"+ "| ");
        }
        System.out.println();

    }

}
