package com.registry.view;

import java.util.ArrayList;

/**
 * Handling all of the printouts. If another language is wanted then just
 * implement this interface and create a new class.
 */
public interface IPrintStrings {

    void displayDeleteMessage();
    void displayDeleteMessageBoat();
    void displayChangeMessage();
    void displayNameMsg();
    void displayP_NumberMsg();
    void displayBoatNmrMsg();
    void displayBoatLengthMsg();
    void displayBoatTypeMsg();
    void displayMemberRemovedMsg();
    void printBoats(ArrayList list);
    void displaySeeMemberMsg();
    void displayIsEqualMsg();


    // Error Messages
    void errorMemberNoeExistMsg();
    void errorLength();
    void errorUserHasNoBoats();
    void errorIntInput();
    void errorIndex();
    void errorDoubleInput();
    void errorFaultyP_Number();

}
