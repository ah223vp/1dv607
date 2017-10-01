package com.registry.view;

import java.util.ArrayList;

/**
 * Class handling all printouts to the user.
 * Replace this class if language needs to be changed.
 */
public class PrintStrings_eng implements IPrintStrings {


   public void getMainMessage(){
       System.out.print("Command: ");
   }
   public void getHelp_msg(){
       System.out.println("             Help!" + "\n" + "\n" +
               "Commands avalable are:" + "\n" +
               "add = adds another member to the registry" + "\n" +
               "list -v = verbose lists the entire registry" + "\n" +
               "list -c = compact lists the entire registry" + "\n" +
               "look = selects a specific member to look at" + "\n" +
               "delete = deletes a member from the registry" + "\n" +
               "change = changes a members information" + "\n" +
               "quit = exits the registry console");
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
   public void displayNameMsg(){
       System.out.print("Name: ");
   }
   public void displayP_NumberMsg(){
       System.out.print("Personal Number: ");
   }
   public void displayBoatNmrMsg(){
       System.out.print("Boat Number: ");
   }
   public void displayBoatLengthMsg(){
       System.out.print("Boat Length: ");
   }
   public void displayBoatTypeMsg(){
       System.out.print("Type Number: ");
   }
   public void displayMemberRemovedMsg(){
       System.out.println("Member Removed: ");
   }
   public void printBoats(ArrayList boats){
       for(int i = 0; i < boats.size(); i++){
           System.out.print("Boat nmr: " + i + " ");
           System.out.print(boats.get(i));
           System.out.println();
       }
   }
   public void displaySeeMemberMsg(){
       System.out.print("Id of member to list: ");
   }
   public void displayIsEqualMsg(){
       System.out.print(" is equal to type: ");
   }

   // Error messages
   public void errorMemberNoeExistMsg(){
       System.out.println("Member does not exist, type list -c to see all members.");
   }
   public void errorLength(){
       System.out.println("Length can´t be 0 or undefined");
   }
   public void errorUserHasNoBoats(){
       System.out.println("User has no boats, type add-b to add boats");
   }
   public void errorIntInput(){
       System.out.println("Invalid input, please input a number");
   }
   public void errorIndex(){
       System.out.println("Specified entity does not exist");
   }
   public void errorDoubleInput(){
       System.out.println("Invalid input, length can´t be 0 or negative");
   }

}
