package com.registry.model.search;


import com.registry.model.Member;

import java.util.List;

public interface ISearch<T> {

    List<Member> search(List<Member> dbList, T t);


}
