package com.registry.model.search;

import com.registry.model.Member;

import java.util.ArrayList;
import java.util.List;

public class SearchByName implements ISearch<String> {


    public List<Member> search(List<Member> dbList, String name){
        List<Member> result = new ArrayList<>();
        for(Member m : dbList){
            if(m.getName().contains(name)){
                result.add(m);
            }
        }
        return result;
    }
}
