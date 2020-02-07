package com.guames.restfulapi.controller;

import com.guames.restfulapi.annotation.AbstractDAO;
import com.guames.restfulapi.dao.GenericDAO;
import com.guames.restfulapi.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @AbstractDAO(entity = Person.class)
    private GenericDAO<Person> teste;


    @GetMapping("name")
    public String getName(){
        return teste.findAll();
    }

}
