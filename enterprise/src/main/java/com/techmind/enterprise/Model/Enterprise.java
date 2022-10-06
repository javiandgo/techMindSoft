package com.techmind.enterprise.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "enterprise")
@EntityListeners(AuditingEntityListener.class)
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private int phone;
    @Column(name = "document")
    private String document;
    @CreatedDate
    @Column(name = "createAt")
    private Date createAt = new Date();
    @LastModifiedDate
    @Column(name = "updateAt")
    private Date updateAt = new Date();
    @JsonIgnore
    @OneToMany(mappedBy = "enterprise")
    private List<Employee> employee;
    @JsonIgnore
    @OneToMany(mappedBy = "enterprise")
    private List<MovementMoney> movementMoney;

    public Enterprise(long id, String name, String address, int phone, String document, Date createAt, Date updateAt, List<Employee> employee, List<MovementMoney> movementMoney) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.document = document;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.employee = employee;
        this.movementMoney = movementMoney;
    }

    public Enterprise() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
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

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public List<MovementMoney> getMovementMoney() {
        return movementMoney;
    }

    public void setMovementMoney(List<MovementMoney> movementMoney) {
        this.movementMoney = movementMoney;
    }
}
