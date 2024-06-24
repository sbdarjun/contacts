package com.arsbd.contacts.repository;

import com.arsbd.contacts.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

// ContactRepository is coming from spring data jpa
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
