package com.arsbd.contacts.repository;

import com.arsbd.contacts.model.EmployeeContact;
import org.springframework.data.jpa.repository.JpaRepository;

// ContactRepository is coming from spring data jpa
public interface EmployeeRepository extends JpaRepository<EmployeeContact, Long> {
}
