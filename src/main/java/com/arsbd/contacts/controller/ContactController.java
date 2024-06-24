package com.arsbd.contacts.controller;

import com.arsbd.contacts.model.Contact;
import com.arsbd.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {

//    data access object layer and repository is simply going to be used to marshal the information into and out of the database
    @Autowired
    private ContactRepository contactRepository;

//
    @GetMapping("/contacts")
    public List<Contact> all(){
        return  contactRepository.findAll();
    }

    @PostMapping("/contacts")
    public Contact createContact(@RequestBody Contact contact){
        return contactRepository.save(contact);
    }


}
