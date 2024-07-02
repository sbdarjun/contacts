package com.arsbd.contacts.controller;

import com.arsbd.contacts.model.InstitutionContact;
import com.arsbd.contacts.repository.EmployeeRepository;
import com.arsbd.contacts.repository.InstitutionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/institutions")
public class InstitutionController {

    @Autowired
    private InstitutionRepository institutionRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public InstitutionController(InstitutionRepository institutionRepository, EmployeeRepository employeeRepository){
        this.institutionRepository = institutionRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<InstitutionContact> getAllContact(){
        return  institutionRepository.findAll();
    }

    @GetMapping("{id}")
    public InstitutionContact get(@PathVariable Long id){
        return institutionRepository.getOne(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public InstitutionContact createContact(@RequestBody InstitutionContact instContact){
        return institutionRepository.save(instContact);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        institutionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public InstitutionContact update(@PathVariable Long id, @RequestBody InstitutionContact institutionContact){
        InstitutionContact existingInstitution = institutionRepository.getOne(id);
        BeanUtils.copyProperties(institutionContact, existingInstitution, "institution_id");
        return institutionRepository.saveAndFlush(existingInstitution);
    }
}
