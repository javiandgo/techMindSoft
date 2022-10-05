package com.techmind.enterprise.Model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class MovementMoney {

    @Id
    private long id;
    @Column(name = "amountMovement")
    private Double amountMovement;
    @Column(name = "detailMovement")
    private String detailMovement;
    @ManyToOne
    private Enterprise enterprise;
    @ManyToOne
    private Employee employee;
    @Column(name = "createAt")
    @CreatedDate
    private Date createAt;
    @Column(name = "updateAt")
    @LastModifiedDate
    private Date updateAt;

    public MovementMoney(long id, Double amountMovement, String detailMovement, Enterprise enterprise, Employee employee, Date createAt, Date updateAt) {
        this.id = id;
        this.amountMovement = amountMovement;
        this.detailMovement = detailMovement;
        this.enterprise = enterprise;
        this.employee = employee;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public MovementMoney() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}