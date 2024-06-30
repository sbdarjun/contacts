package com.arsbd.contacts.repository;

import com.arsbd.contacts.model.InstitutionContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionRepository extends JpaRepository<InstitutionContact, Long> {
}
