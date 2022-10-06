package com.techmind.enterprise.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table (name = "profile")
@EntityListeners(AuditingEntityListener.class)
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
    @Column(name = "image")
    private String image;
    @Column(name = "phone")
    private String phone;

    @JsonIgnore
    @OneToOne(mappedBy = "profile")
    private Employee employee;
    @CreatedDate
    @Column(name = "createAt")
    private Date createAt = new Date();
    @LastModifiedDate
    @Column(name = "updateAt")
    private Date updateAt = new Date();

    public Profile(String id, String username, String password, String image, String phone, Employee employee, Date createAt, Date updateAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.image = image;
        this.phone = phone;
        this.employee = employee;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Profile() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
