package com.techmind.enterprise.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    private String nombreUsuario;
    @Column
    private String password;
    @Column
    private String nombrePersona;

    public Profile(String nombreUsuariso, String password, String nombrePersona) {
        this.nombreUsuario = nombreUsuariso;
        this.password = password;
        this.nombrePersona = nombrePersona;
    }

    public Profile() {
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuariso) {
        this.nombreUsuario = nombreUsuariso;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }
}
