package com.techmind.enterprise.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    @OneToOne
    private Profile profile;
    @Column(name = "roleName")
    private String roleName;
    @CreatedDate
    @Column(name = "createAt")
    private Date createAt = new Date();
    @LastModifiedDate
    @Column(name = "updateAt")
    private Date updateAt = new Date();
    @ManyToOne
    @JoinColumn(name = "enterprise_id", nullable = false)
    private Enterprise enterprise;
    @OneToMany(mappedBy = "employee")
    private List<MovementMoney> movementMoney;

    public Employee(long id, String name, String email, Profile profile, String roleName, Date createAt, Date updateAt, Enterprise enterprise, List<MovementMoney> movementMoney) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profile = profile;
        this.roleName = roleName;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.enterprise = enterprise;
        this.movementMoney = movementMoney;
    }

    public Employee() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public List<MovementMoney> getMovementMoney() {
        return movementMoney;
    }

    public void setMovementMoney(List<MovementMoney> movementMoney) {
        this.movementMoney = movementMoney;
    }
}