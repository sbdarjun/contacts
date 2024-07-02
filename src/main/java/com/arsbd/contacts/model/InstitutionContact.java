package com.arsbd.contacts.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "institution_contact")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InstitutionContact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long institution_id;

    @Column(name = "institution_name")
    @JsonProperty("institution_name")
    private String institution_name;

    @Column(name = "institution_address")
    @JsonProperty("institution_address")
    private String institution_address;

    @Column(name = "institution_email")
    @JsonProperty("institution_email")
    private String institution_email;

    @Column(name = "website")
    @JsonProperty("website")
    private String website;

    @Column(name = "institution_phone")
    @JsonProperty("institution_phone")
    private String institution_phone;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "institution_employee")
//    joinColumns = @JoinColumn(name = "inst_id", referencedColumnName = "institution_id"),
//    inverseJoinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "employee_id"))
    @JsonManagedReference
    private Set<EmployeeContact> employees = new HashSet<>();

}
