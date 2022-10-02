package com.techmind.enterprise.Model;

import javax.persistence.*;

@Entity
@Table(name = "movements")
public class MovementMoney {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "amountMovement")
    private double amountMovement;
    @Column(name = "detailMovement")
    private String detailMovement;

    public MovementMoney(double amountMovement, String detailMovement) {
        this.amountMovement = amountMovement;
        this.detailMovement = detailMovement;
    }

    public MovementMoney() {
    }

    public double getAmountMovement() {
        return amountMovement;
    }

    public void setAmountMovement(double amountMovement) {
        this.amountMovement = amountMovement;
    }

    public String getDetailMovement() {
        return detailMovement;
    }

    public void setDetailMovement(String detailMovement) {
        this.detailMovement = detailMovement;
    }
}
