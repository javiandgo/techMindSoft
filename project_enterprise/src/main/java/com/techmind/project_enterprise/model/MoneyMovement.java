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
@Table(name = "movements")
public class MoneyMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovement;

    @Column(name = "amount", nullable = false, length = 50)
    private Float amount;

    @Column(name = "type_movement",nullable = false, length=150)
    private String type_movement;

    @Column(name = "concept", nullable = false, length = 150)
    private String concept;

    @Column(name = "user_register", nullable = false, length = 80)
    private String user_register;

    private boolean enable;
}
