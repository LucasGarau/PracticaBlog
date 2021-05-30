package com.liceu.userdatabase.model;

public class Comment {
    private int id;
    private String cos;
    private int userid;
    private int postid;
    private String username;

    public Comment() {
    }

    public Comment(int id, String cos, int userid, int postid, String username) {
        this.id = id;
        this.cos = cos;
        this.userid = userid;
        this.postid = postid;
        this.username = username;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getCos() {
        return cos;
    }

    public void setCos(String cos) {
        this.cos = cos;
    }
}
