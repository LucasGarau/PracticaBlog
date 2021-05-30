package com.liceu.userdatabase.model;

import java.util.Date;

public class Post {
    private int id;
    private int blogid;
    private String titol;
    private String cos;
    private Date date;
    private Date modate;

    public Post() {

    }

    public Post(int id, String titol, String cos) {
        this.id = id;
        this.cos =cos;
        this.titol = titol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Post(int id, int blogid, String titol, String cos, Date date, Date modate) {
        this.id = id;
        this.blogid =blogid;
        this.titol = titol;
        this.cos = cos;
        this.date=date;
        this.modate=modate;

    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getCos() {
        return cos;
    }

    public void setCos(String cos) {
        this.cos = cos;
    }

    public Date getDate() {
        return date;
    }

    public int getBlogid() {
        return blogid;
    }

    public void setBlogid(int blogid) {
        this.blogid = blogid;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getModate() {
        return modate;
    }

    public void setModate(Date modate) {
        this.modate = modate;
    }
}
