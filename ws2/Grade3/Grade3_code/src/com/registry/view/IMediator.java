package com.registry.view;

import com.registry.model.IDBControl;

import java.util.List;

public interface IMediator {

    List searchMembersByName();

    void registerDB(IDBControl m_db);
}
