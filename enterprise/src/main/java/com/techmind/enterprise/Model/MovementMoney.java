package com.techmind.enterprise.Model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction")
@EntityListeners(AuditingEntityListener.class)
public class MovementMoney {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "amountMovement")
    private Double amountMovement;
    @Column(name = "detailMovement")
    private String detailMovement;
    @CreatedDate
    @Column(name = "createAt")
    private Date createAt = new Date();
    @LastModifiedDate
    @Column(name = "updateAt")
    private Date updateAt = new Date();
    @ManyToOne
    private Enterprise enterprise;
    @ManyToOne
    private Employee employee;

    public MovementMoney(Long id, Double amountMovement, String detailMovement, Enterprise enterprise, Employee employee, Date createAt, Date updateAt) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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