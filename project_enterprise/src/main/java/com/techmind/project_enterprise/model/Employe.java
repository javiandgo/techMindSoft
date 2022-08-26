package com.techmind.project_enterprise.model;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Data
@Entity
@Table(name = "employees")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmploye;

    @Column(name="name_employee",nullable = false, length=50)
    private String name_employee;

    @Column(name="email_employee",nullable = false, length=150)
    private String email_employee;

    @Column(name="enterprise_employee",nullable = false, length=150)
    private String enterprise_employee;

    @Column(name="rol_employee",nullable = false, length=150)
    private String rol_employee;

    private boolean enable;
}
