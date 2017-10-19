package com.registry.view;

import com.registry.model.Boat;
import com.registry.model.IDBControl;
import com.registry.model.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoatActions {

    private IPrintStrings print;
    private Scanner scan = new Scanner(System.in);
    private MemberActions memberActions;
    private IDBControl m_DB;

    private IInputObserver sub;

    public BoatActions(MemberActions memberActions, IDBControl m_DB, IInputObserver sub){
        this.print = memberActions.getPrintString();
        this.memberActions = memberActions;
        this.m_DB = m_DB;

        this.sub = sub;

    }

    // Boat Methods
    public void addBoat(){
        print.displayChangeMessage();
        Member member = memberActions.getMember();
        // Creating boat in Member class
        Boat boat = member.getBoatObject();
        String type = selectBoatType(boat);

        print.displayBoatLengthMsg();
        Double length = getDoubleInput();

        if(!boat.setLength(length) || !boat.setType(type)){
            print.errorLength();
            return;
        }
        member.addBoat(boat);
        m_DB.saveMember();


    }
    public void deleteBoat(){
        print.displayDeleteMessageBoat();
        Member member = memberActions.getMember();
        Boat boat = selectBoat(member);
        member.removeBoat(boat);
        m_DB.saveMember();
    }
    public void changeBoatInfo(){
        print.displayChangeMessage();
        Member member = memberActions.getMember();

        Boat boat = selectBoat(member);
        String type = selectBoatType(boat);

        print.displayBoatLengthMsg();
        Double length = getDoubleInput();

        // Error handling in the boatClass
        if(!boat.setLength(length)){
            print.errorLength();
            return;
        }
        boat.setType(type);
        m_DB.saveMember();
    }

    /**
     * Selects a boat from a promted list
     * @param member The member to select from
     * @return Boat object
     */
    private Boat selectBoat(Member member){
        ArrayList boats = member.getBoats();
        if(boats.size() == 0){
            print.errorUserHasNoBoats();
            sub.notified();
        }
        print.printBoats(boats);
        print.displayBoatNmrMsg();
        int selection = getIntInput();

        validateIndex(boats, selection);
        return member.getBoats().get(selection);
    }

    /**
     * Selects a boat type from the boat object
     * @param boat Boat objet to select type upon
     * @return The type to add to the boat object
     */
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

    /**
     * Validating an index in a List.
     * @param list The list to validate.
     * @param index The index to validate.
     */
    private void validateIndex(List list, int index){
        try{
            if(index < 0 || index > list.size()-1){
                throw new Exception();
            }
        }catch(Exception e){
            print.errorIndex();
            scan.nextLine();
            sub.notified();
        }
    }
    /**
     * Get integer input, used when selecting in lists
     * @throw Error if input is not an int
     * @return integer input
     */
    private int getIntInput(){

        int index = -1;
        scan.useDelimiter("\n");
        try{
            index = scan.nextInt();
            scan.nextLine();
        }catch(Exception e){
            print.errorIntInput();
            scan.nextLine();
            sub.notified();
        }

        return index;
    }
    private Double getDoubleInput(){
        double dbl = -1;
        scan.useDelimiter("\n");
        try{
            dbl = scan.nextDouble();
            scan.nextLine();

        }catch(Exception e){

            scan.nextLine();
            if(dbl == -1){
                return dbl;
            }
            print.errorDoubleInput();
            sub.notified();
        }
        return dbl;
    }
}
