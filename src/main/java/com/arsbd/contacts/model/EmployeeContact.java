package com.arsbd.contacts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="employee_contact")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmployeeContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employee_id;

    @Column(name = "full_name")
    @JsonProperty("full_name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "employee_position")
    @JsonProperty("employee_position")
    private String employeePosition;

    @Column(name = "phone_number")
    @JsonProperty("phone_number")
    private String phone;

    @Column(name = "full_address")
    @JsonProperty("full_address")
    private String address;

    @Column(name = "job_position")
    @JsonProperty("job_position")
    private String jobPosition;

    @Lob
    @Column(name = "contact_photo")
    public byte[] photo;

    @ManyToMany (mappedBy = "employees")
    @JsonIgnore
    private Set<InstitutionContact> institutions = new HashSet<>();

    public EmployeeContact(){}

    public Set<InstitutionContact> getInstitutions() {
        return institutions;
    }

    public void setInstitutions(Set<InstitutionContact> institutions) {
        this.institutions = institutions;
    }

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

}
