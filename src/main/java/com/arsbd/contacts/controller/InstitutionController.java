package com.arsbd.contacts.controller;

import com.arsbd.contacts.exception.ResourceNotFound;
import com.arsbd.contacts.model.InstitutionContact;
import com.arsbd.contacts.repository.InstitutionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/institutions")
public class InstitutionController {

    @Autowired
    private InstitutionRepository institutionRepository;

    @GetMapping
    public List<InstitutionContact> getAllContact() {
        return institutionRepository.findAll();
    }

    @GetMapping("/{institution_id}")
    public ResponseEntity<InstitutionContact> getInstitutionById(@PathVariable Long institution_id) {
        InstitutionContact instContact = institutionRepository.findById(institution_id).orElseThrow(() -> new ResourceNotFound("Institution not exist with id :" + institution_id));
        return ResponseEntity.ok(instContact);
    }

    @PostMapping
    public InstitutionContact createContact(@RequestBody final InstitutionContact instContact) {
        return institutionRepository.save(instContact);
    }

    @RequestMapping(value = "/{institution_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Boolean>> deleteInstitution(@PathVariable Long institution_id) {
        InstitutionContact institutionContact = institutionRepository.findById(institution_id)
                .orElseThrow(() -> new ResourceNotFound("Institution not exist with id :" + institution_id));
        institutionRepository.delete(institutionContact);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/{institution_id}", method = RequestMethod.PUT)
    public InstitutionContact update(@PathVariable Long institution_id, @RequestBody InstitutionContact institutionContact) {
        InstitutionContact existingInstitution = institutionRepository.findById(institution_id)
                .orElseThrow(() -> new ResourceNotFound("Institution not found with id :" + institution_id));
        BeanUtils.copyProperties(institutionContact, existingInstitution, "institution_id");
        return institutionRepository.saveAndFlush(existingInstitution);
    }

}
