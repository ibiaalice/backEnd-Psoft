package com.model;

public class Like{
    private String email;
    private long idUser;

    public Like(long id, String email){
        this.email = email;
        this.idUser = id;
    }

    public long getIdUser(){
        return this.idUser;
    }

    public String getEmail(){
        return this.email;
    }
}
