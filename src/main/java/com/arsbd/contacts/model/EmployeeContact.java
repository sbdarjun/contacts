package com.arsbd.contacts.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="employee_contact")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeContact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employee_id;

    @Column(name = "full_name")
    @JsonProperty("full_name")
    private String full_name;

    @Column(name = "email")
    private String email;

    @Column(name = "employee_position")
    @JsonProperty("employee_position")
    private String employee_position;

    @Column(name = "phone_number")
    @JsonProperty("phone_number")
    private String phone_number;

    @Column(name = "full_address")
    @JsonProperty("full_address")
    private String full_address;

    @Column(name = "job_position")
    @JsonProperty("job_position")
    private String job_position;

//    @Lob
//    @Column(name = "contact_photo")
//    public byte[] contact_photo;

    @ManyToMany (mappedBy = "employees")
//    @JsonIgnore
    @JsonBackReference
    private Set<InstitutionContact> institutions = new HashSet<>();

}
