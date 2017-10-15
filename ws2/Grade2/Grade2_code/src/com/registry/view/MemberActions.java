package com.registry.view;


import com.registry.model.IDBControl;
import com.registry.model.Member;


import java.util.Scanner;

public class MemberActions {

    private IPrintStrings print;
    private Scanner scan = new Scanner(System.in);
    private IDBControl m_DB;

    private IInputObserver sub;

    public MemberActions(IDBControl m_DB, IInputObserver sub) {
        this.print = new PrintStrings_eng();
        this.m_DB = m_DB;
        this.sub = sub;
    }
    public IPrintStrings getPrintString(){
        return this.print;
    }


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
            // Move to a print method
            for(Member m : m_DB.getMembers()){
                System.out.println("Member: " + m.getName() + " , " + "M_id =" + m.getM_id() + " , " + "NoBoats: " + m.getN_boats());
            }
        }
    }
    /**
     * Prints the selected member instance. Can be used with a loop.
     * @param member Member to be printed.
     */
    private void printMember(Member member){

        System.out.print("Member: " + member.getName() + "\n"+ "\t" + "Info: " +"SocialSecNum = " + member.getP_number()
                + ", M_id = " + member.getM_id() + "\n" + "\t" + "Boats(" + member.getN_boats() +"): ");
        for(int i = 0; i < member.getBoats().size(); i++){
            System.out.print(" |" + member.getBoats().get(i).getType() + " , " + member.getBoats().get(i).getLength() +" m"+ "| ");
        }

        System.out.println();

    }
    private Member getMemberInfo(Member member){
        scan.reset();
        print.displayNameMsg();
        String name = scan.nextLine();

        print.displayP_NumberMsg();
        long p_number = getLongInput();

        // Error handling in the member class
        if (!member.setName(name) || !member.setP_number(p_number)) {
            print.errorFaultyP_Number();
            sub.notified();
        }
        return member;
    }
    public Member getMember(){
        int id = -1;
        Member member = null;
        // Needed to break command if user try to have the line blank.
        scan.useDelimiter("\n");
        try{
            id = scan.nextInt();
            scan.nextLine();
            if(m_DB.memberExists(id)){
                member = m_DB.getMember(id);
            }else {
                print.errorMemberNoeExistMsg();
                sub.notified();
            }

        }catch(Exception e){
            scan.nextLine();
            print.errorIntInput();
            sub.notified();


        }
        return member;
    }
    /**
     * Get integer input, used when selecting in lists
     * @throw Error if input is not an int
     * @return integer input
     */
    private long getLongInput(){

        long p_number = -1;
        scan.useDelimiter("\n");
        try{
            p_number = scan.nextLong();
            scan.nextLine();
        }catch(Exception e){
            scan.nextLine();
            System.out.println("Detta har med personnummer att göra");
            sub.notified();
        }

        return p_number;
    }

}
