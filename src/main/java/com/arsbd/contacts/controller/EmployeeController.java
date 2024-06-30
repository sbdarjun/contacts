package com.arsbd.contacts.controller;

import com.arsbd.contacts.model.EmployeeContact;
import com.arsbd.contacts.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

//    data access object layer and repository is simply going to be used to marshal the information into and out of the database
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<EmployeeContact> getAllContact(){
        return  employeeRepository.findAll();
    }

    @GetMapping("{id}")
    public EmployeeContact get(@PathVariable Long id){
        return employeeRepository.getOne(id);
    }

    @PostMapping
    public EmployeeContact createContact(@RequestBody EmployeeContact contact){
        return employeeRepository.saveAndFlush(contact);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        employeeRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public EmployeeContact update(@PathVariable Long id, @RequestBody EmployeeContact employeeContact){
        EmployeeContact existingEmployee = employeeRepository.getOne(id);
        BeanUtils.copyProperties(employeeContact, existingEmployee, "employee_id");
        return employeeRepository.saveAndFlush(existingEmployee);
    }
}
