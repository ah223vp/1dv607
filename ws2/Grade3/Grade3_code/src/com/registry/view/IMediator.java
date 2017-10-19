package com.registry.view;

import com.registry.model.IDBControl;
import com.registry.model.Member;

import java.util.List;

public interface IMediator {

    List<Member> search(String type);

    void registerDB(IDBControl m_db);
}
