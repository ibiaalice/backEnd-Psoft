package com.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Comments")
public class Comment {
    @Id
    private long chave;

    @Column(name = "discipline_comments")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("usuario")
    private Usuario user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("discipline")
    private Discipline discipline;


    private Long reference;

    public Comment(){
        this.text = "";

    }

    public Comment(Discipline discipline, Usuario usuario, String comment) {
        this.discipline = discipline;
        this.user = usuario;
        this.text = comment;

    }

    public Comment(Discipline discipline , Usuario usuario, String comment, Comment principalComment) {
        this(discipline, usuario, comment);
    }

    public Discipline getDiscipline() {
        return discipline;
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
