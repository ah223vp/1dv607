package com.registry.view;

import java.util.ArrayList;

public interface IPrintStrings {

    void getMainMessage();
    void getHelp_msg();
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

}
