package com.liceu.userdatabase.model;

public class User {
    private int id;
    private String Nom;
    private String Pass;

    public User(int id, String nom) {
        this.id = id;
        Nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(int id, String nom, String pass) {

        this.id = id;
        this.Nom = nom;
        this.Pass = pass;

    }

    public User() {
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }
}


