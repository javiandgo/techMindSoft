package com.techmind.enterprise.Model;

import javax.persistence.*;

@Entity
@Table(name = "movements")
public class MovementMoney {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "amountMovement")
    private Double amountMovement;
    @Column(name = "detailMovement")
    private String detailMovement;
    @Column(name = "userOwner")
    private String userOwner;

    public MovementMoney(Double amountMovement, String detailMovement, String userOwner) {
        this.amountMovement = amountMovement;
        this.detailMovement = detailMovement;
        this.userOwner = userOwner;
    }

    public MovementMoney() {
    }

    public Double getAmountMovement() {
        return amountMovement;
    }

    public void setAmountMovement(Double amountMovement) {
        this.amountMovement = amountMovement;
    }

    public String getDetailMovement() {
        return detailMovement;
    }

    public void setDetailMovement(String detailMovement) {
        this.detailMovement = detailMovement;
    }

    public String getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(String userOwner) {
        this.userOwner = userOwner;
    }
}