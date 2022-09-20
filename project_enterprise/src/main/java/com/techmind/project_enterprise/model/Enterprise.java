package com.techmind.project_enterprise.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "enterprise")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnterprise;

    @Column(name="name_enterprise",nullable = false, length=50)
    private String name_enterprise;

    @Column(name="nit_enterprise",nullable = false, length=150)
    private Integer nit_enterprise;

    @Column(name="address_enterprise",nullable = false, length=150)
    private String address_enterprise;

    @Column(name="phone_enterprise",nullable = false, length=150)
    private Integer phone_enterprise;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


}
