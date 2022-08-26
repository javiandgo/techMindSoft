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
@Table(name = "enterprises")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEnterprise;

    @Column(name="name_enterprise",nullable = false, length=50)
    private String name_enterprise;

    @Column(name="address_enterprise",nullable = false, length=150)
    private String address_enterprise;

    @Column(name="phone_enterprise",nullable = false, length=150)
    private Integer phone_enterprise;

    @Column(name="nit_enterprise",nullable = false, length=150)
    private Integer nit_enterprise;

    private boolean enable;
}
