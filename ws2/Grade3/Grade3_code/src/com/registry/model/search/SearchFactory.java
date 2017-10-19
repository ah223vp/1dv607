package com.registry.model.search;

public class SearchFactory {

    public ISearch getSearchType(String type){

        if(type.equals("NAME")){
            return new SearchByName();
        }else if(type.equals("AGE")){
            return new SearchByAge();
        }else if(type.equals("TYPE")){
            return new SearchByBoatType();
        }

        return null;
    }
}
