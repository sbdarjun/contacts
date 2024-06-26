package com.arsbd.contacts.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name="employee_contact")
public class EmployeeContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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


    public EmployeeContact(){}

    public EmployeeContact(String name, String email, String employeePosition, String phone, String address, String jobPosition){
        super();
        this.name = name;
        this.email = email;
        this.employeePosition = employeePosition;
        this.phone = phone;
        this.address = address;
        this.jobPosition = jobPosition;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

}
