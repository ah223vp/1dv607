package com.registry.model.search;

import com.registry.model.Member;

import java.util.ArrayList;
import java.util.List;

public class SearchByAge implements ISearch<Integer>{

    public List<Member> search(List<Member> dbList, Integer age){
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
