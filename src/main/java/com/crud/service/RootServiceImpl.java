package com.crud.service;

import com.crud.entity.Root;
import com.crud.repo.RootRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RootServiceImpl implements RootService{

    @Autowired
    RootRepository repo;

//    public Root apiCaller(){
//        String url = "https://randomuser.me/api/";
//        RestTemplate restTemplate = new RestTemplate();
//        Root response = restTemplate.getForObject(url, Root.class);
//
//        return response;
//    }

    @Override
    public Long saveRootUser(Root root) {
        return  repo.save(root).getId();

    }

    @Override
    public Root getAllRootUser() {
        return (Root) repo.findAll();

    }
}
