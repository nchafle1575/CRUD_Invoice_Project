package com.crud.controller;

import com.crud.entity.Root;
import com.crud.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class RootController {

@Autowired
    RootService rootService;

    @GetMapping("/gettingRandomUser")
    public ResponseEntity<Root> userString(){
        ResponseEntity<Root> resp = null;
        String url = "https://randomuser.me/api/";
        RestTemplate restTemplate = new RestTemplate();

        try {
            Root response = restTemplate.getForObject(url, Root.class);
            resp = new ResponseEntity<>( response, HttpStatus.OK);

        }catch(Exception e){
            e.printStackTrace();
                new ResponseEntity<String>("Invaild Id you have entered", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return resp;
    }

//    @GetMapping("/")

}
