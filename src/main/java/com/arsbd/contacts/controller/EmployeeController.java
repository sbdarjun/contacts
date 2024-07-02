package com.arsbd.contacts.controller;

import com.arsbd.contacts.exception.ResourceNotFound;
import com.arsbd.contacts.model.EmployeeContact;
import com.arsbd.contacts.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    //    data access object layer and repository is simply going to be used to marshal the information into and out of the database
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<EmployeeContact> getAllContact() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{employee_id}")
    public ResponseEntity<EmployeeContact> getEmployeeById(@PathVariable Long employee_id) {
        EmployeeContact empContact = employeeRepository.findById(employee_id).orElseThrow(() -> new ResourceNotFound("Employee not exist with id :" + employee_id));
        return ResponseEntity.ok(empContact);
    }

    @PostMapping
    public EmployeeContact createContact(@RequestBody EmployeeContact contact) {
        return employeeRepository.saveAndFlush(contact);
    }

    @RequestMapping(value = "/{employee_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long employee_id) {
        EmployeeContact employeeContact = employeeRepository.findById(employee_id)
                .orElseThrow(() -> new ResourceNotFound("Employee not exist with id :" + employee_id));
        employeeRepository.delete(employeeContact);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "{employee_id}", method = RequestMethod.PUT)
    public EmployeeContact update(@PathVariable Long employee_id, @RequestBody EmployeeContact employeeContact) {
        EmployeeContact existingEmployee = employeeRepository.findById(employee_id)
                .orElseThrow(() -> new ResourceNotFound("Employee not found with id :" + employee_id));
        BeanUtils.copyProperties(employeeContact, existingEmployee, "employee_id");
        return employeeRepository.saveAndFlush(existingEmployee);
    }
}
