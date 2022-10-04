package com.techmind.enterprise.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "enterpriseEmployee")
    private String enterpriseEmployee;
    @Column(name = "rolEmployee")
    private String rolEmployee;
    @JsonIgnore
    @OneToOne (mappedBy = "employee")
    private Profile profile;

    public Employee(long id, String name, String email, String enterpriseEmployee, String rolEmployee, Profile profile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.enterpriseEmployee = enterpriseEmployee;
        this.rolEmployee = rolEmployee;
        this.profile = profile;

    }

    public Employee() {
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
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

    public String getEnterpriseEmployee() {
        return enterpriseEmployee;
    }

    public void setEnterpriseEmployee(String enterpriseEmployee) {
        this.enterpriseEmployee = enterpriseEmployee;
    }

    public String getRolEmployee() {
        return rolEmployee;
    }

    public void setRolEmployee(String rolEmployee) {
        this.rolEmployee = rolEmployee;
    }
}