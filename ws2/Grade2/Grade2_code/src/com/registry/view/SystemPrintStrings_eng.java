package com.registry.view;

public class SystemPrintStrings_eng implements ISystemPrintStrings {

    public String getMainMessage(){
        return "Command: ";
    }
    public String getHelpMessage(){
        return "             Help!" + "\n" + "\n" +
                "Commands avalable are:" + "\n" +
                "add -m = adds another member to the registry" + "\n" +
                "add -b = adds another boat to the desired member" + "\n" +
                "list -v = verbose lists the entire registry" + "\n" +
                "list -c = compact lists the entire registry" + "\n" +
                "look = selects a specific member to look at" + "\n" +
                "delete -m = deletes a member from the registry" + "\n" +
                "delete -b = deletes a boat from the desired member" + "\n" +
                "change -m = changes a members information" + "\n" +
                "change -b = changes a boats information" + "\n" +
                "quit = exits the registry console";
    }
    public String getWelcomeMessage(){
        return "Welcome to the pirate boatcluds registry. Type help or any key to display avalable commands.";
    }
}
