package com.model;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera o valor do id
    private long id;
    @Column(name="reference")
    private long reference;
    @Column(name="text")
    private String text;
    @Column(name= "email")
    private String email;
    private Date data;
    @Column(name= "Deleted")
    private Boolean deleted;

    public  Comment (){
        this.deleted = false;
        this.data = new Date();
        this.text = "";
        this.reference = 0;
    }

    public Comment(long reference, String text, String email){
        this.reference = reference;
        this.text = text;
        this.email = email;
        this.data = new Date();
        this.deleted = false;
    }

    //getters and setters

    public boolean getDeleted(){
        return  this.deleted;
    }

    public String getText() {
        return text;
    }

    public String getEmail() {
        return email;
    }

    public long getId() {
        return id;
    }

    public long getReference() {
        return reference;
    }

    public Date getData(){
        return  this.data;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setReference(long reference) {
        this.reference = reference;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDeleted(boolean deleted){
        this.deleted = deleted;
    }

    //métodos habituais

    @Override
    public String toString() {
        return this.reference + "- " + this.text + " - " + this.email;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


}
