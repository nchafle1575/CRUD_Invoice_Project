package com.crud.service;

import com.crud.entity.Invoice;
import com.crud.entity.Root;

import java.util.ArrayList;
import java.util.List;

public interface RootService {

    Long saveRootUser(Root root);
    Root getAllRootUser();
//    public Object apiCaller();
}
