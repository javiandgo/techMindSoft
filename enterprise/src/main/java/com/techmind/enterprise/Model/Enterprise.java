package com.techmind.enterprise.Model;

import javax.persistence.*;

@Entity
@Table(name = "enterprise")
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "adress")
    private String adress;
    @Column(name = "phone")
    private int phone;
    @Column(name = "nit")
    private String nit;

    public Enterprise(String name, String adress, int phone, String nit) {
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.nit = nit;
    }

    public Enterprise() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
