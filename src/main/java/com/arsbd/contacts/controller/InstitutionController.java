package com.arsbd.contacts.controller;

import com.arsbd.contacts.model.InstitutionContact;
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

    @GetMapping
    public List<InstitutionContact> getAllContact(){
        return  institutionRepository.findAll();
    }

    @GetMapping("{id}")
    public InstitutionContact get(@PathVariable Long id){
        return institutionRepository.getOne(id);
    }

    @PostMapping
    public InstitutionContact createContact(@RequestBody final InstitutionContact instContact){
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
