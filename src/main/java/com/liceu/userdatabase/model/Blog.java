package com.liceu.userdatabase.model;

public class Blog {
    private int id;
    private String Nom;
    private int userid;

    public Blog() {
    }

    public Blog(int id, String nom, int userid) {
        this.id = id;
        Nom = nom;
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
