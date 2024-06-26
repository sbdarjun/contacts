package com.arsbd.contacts.controller;

import com.arsbd.contacts.model.EmployeeContact;
import com.arsbd.contacts.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

//    data access object layer and repository is simply going to be used to marshal the information into and out of the database
    @Autowired
    private EmployeeRepository employeeRepository;

//
    @GetMapping("/employees")
    public List<EmployeeContact> getAllContact(){
        return  employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public EmployeeContact createContact(@RequestBody EmployeeContact contact){
        return employeeRepository.save(contact);
    }


}
