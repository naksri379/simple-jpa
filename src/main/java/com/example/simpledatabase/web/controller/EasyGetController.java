package com.example.simpledatabase.web.controller;

import com.example.simpledatabase.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EasyGetController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/getAll")
    public String getAll(){
        return customerService.getAllData();
    }

    @GetMapping(path = "/getByLastName/{lastName}")
    public String getByLastName(@PathVariable("lastName") String lastName){
        return customerService.getByLastNameData(lastName);
    }
}
