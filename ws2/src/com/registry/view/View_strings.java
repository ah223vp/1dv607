package com.registry.view;

import java.util.ArrayList;

public class View_strings {

    private String main;
    private String help_msg;

    public View_strings(){
        main = "Command: ";
        help_msg = "             Help!" + "\n" + "\n" +
        "Commands avalable are:" + "\n" +
        "add = adds another member to the registry" + "\n" +
        "list -v = verbose lists the entire registry" + "\n" +
        "list -c = compact lists the entire registry" + "\n" +
        "look = selects a specific member to look at" + "\n" +
        "delete = deletes a member from the registry" + "\n" +
        "change = changes a members information" + "\n" +
        "quit = exits the registry console";
    }

   public void getMainMessage(){
       System.out.print(main);
   }
   public void getHelp_msg(){
       System.out.println(help_msg);
   }
   public void displayDeleteMessage(){
       System.out.print("Member id of member to be deleted: ");
   }
    public void displayDeleteMessageBoat(){
        System.out.print("Member id of member to have it´s boat deleted: ");
    }
   public void displayChangeMessage(){
       System.out.print("Member id of member to change: ");
   }
   public void displayMemberNoeExistMsg(){
       System.out.println("Member does not exist, type list -c to see all members.");
   }
   public void printBoats(ArrayList boats){
       for(int i = 0; i < boats.size(); i++){
           System.out.print("Boat nmr: " + i + " ");
           System.out.print(boats.get(i));
           System.out.println();
       }
   }

}
