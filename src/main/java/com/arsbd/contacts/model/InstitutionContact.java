package com.arsbd.contacts.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "institution_contact")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class InstitutionContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long institution_id;

    @Column(name = "institution_name")
    @JsonProperty("institution_name")
    private String institutionName;

    @Column(name = "institution_address")
    @JsonProperty("institution_address")
    private String institutionAddress;

    @Column(name = "institution_email")
    @JsonProperty("institution_email")
    private String institutionEmail;

    @Column(name = "website")
    @JsonProperty("website")
    private String website;

    @Column(name = "institution_phone")
    @JsonProperty("institution_phone")
    private String institutionPhone;

    @ManyToMany
    @JoinTable(name = "institution_employee",
    joinColumns = @JoinColumn(name = "institution_id"),
    inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Set<EmployeeContact> employees = new HashSet<>();


    public InstitutionContact(){}

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
