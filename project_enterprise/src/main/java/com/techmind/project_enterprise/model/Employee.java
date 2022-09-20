package com.techmind.project_enterprise.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmploye;

    @Column(name = "name_employee", nullable = false, length = 50)
    private String name_employee;

    @Email
    @Column(name = "email_employee", nullable = false, length = 150)
    private String email_employee;

    @OneToOne
    @JoinColumn(name = "id_profile", nullable = false, foreignKey = @ForeignKey(name = "fk_profile"))
    private Profile profile;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "roleName")
    private RoleName roleName;

    @ManyToOne
    @JoinColumn(name = "id_enterprise",nullable = false, foreignKey = @ForeignKey(name = "fk_enterprise"))
    private Enterprise enterprise;

    @ManyToOne
    @JoinColumn(name = "id_transaction",nullable = false, foreignKey =@ForeignKey(name = "fk_transaction"))
    private Transaction transaction;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


}
