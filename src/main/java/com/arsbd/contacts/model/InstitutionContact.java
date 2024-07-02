package com.arsbd.contacts.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "institution_contact")
public class InstitutionContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long institution_id;

    private String institutionName;

    private String institutionAddress;

    private String institutionEmail;

    private String website;

    private String institutionPhone;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "institution_employee")
    private Set<EmployeeContact> employees = new HashSet<>();

    public InstitutionContact() {
    }

    public Set<EmployeeContact> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeContact> employees) {
        this.employees = employees;
    }

    public long getInstitution_id() {
        return institution_id;
    }

    public void setInstitution_id(long institution_id) {
        this.institution_id = institution_id;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getInstitutionAddress() {
        return institutionAddress;
    }

    public void setInstitutionAddress(String institutionAddress) {
        this.institutionAddress = institutionAddress;
    }

    public String getInstitutionEmail() {
        return institutionEmail;
    }

    public void setInstitutionEmail(String institutionEmail) {
        this.institutionEmail = institutionEmail;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getInstitutionPhone() {
        return institutionPhone;
    }

    public void setInstitutionPhone(String institutionPhone) {
        this.institutionPhone = institutionPhone;
    }
}
