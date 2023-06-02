package com.example.apiprueba.module.auth.dto;

public class UsersLoginModel {

    private String email;

    private String pass;

    public UsersLoginModel() {
    }

    public UsersLoginModel(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
