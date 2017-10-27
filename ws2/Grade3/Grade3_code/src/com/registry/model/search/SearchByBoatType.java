package com.registry.model.search;

import com.registry.model.Member;

import java.util.ArrayList;
import java.util.List;

public class SearchByBoatType implements ISearch<String> {


    /**
     *
     * Implement if I have time
     *
     *
     */

    public List<Member> search(List<Member> dbList, String type){
        List<Member> result = new ArrayList<>();
        for(Member m : dbList){
            /*
            if(m.getName().contains(name)){
                result.add(m);
            }
            */
        }
        return result;
    }
}
