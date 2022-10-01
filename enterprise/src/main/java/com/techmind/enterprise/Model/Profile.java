package com.techmind.enterprise.Model;

public class Profile {

    private String nombreUsuariso;
    private String password;
    private String nombrePersona;

    public Profile(String nombreUsuariso, String password, String nombrePersona) {
        this.nombreUsuariso = nombreUsuariso;
        this.password = password;
        this.nombrePersona = nombrePersona;
    }

    public Profile() {
    }

    public String getNombreUsuariso() {
        return nombreUsuariso;
    }

    public void setNombreUsuariso(String nombreUsuariso) {
        this.nombreUsuariso = nombreUsuariso;
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
