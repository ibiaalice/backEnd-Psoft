package com.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Comments")
public class Comment {
    @EmbeddedId
    private UserToDiscipline id;

    @Column(name = "discipline_comments")
    private String comment;

    @Column(name = "visibility")
    private boolean visibility;


    @ManyToOne
    private Comment principalComment;

    @OneToMany(mappedBy = "principalComment") /*definindo o auto relacionamento*/
    private List<Comment> othersComments;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("usuario")
    private Usuario user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("discipline")
    private Discipline discipline;

    public Comment(){
        this.id = new UserToDiscipline();
        this.comment = "";
        this.principalComment = null;
        this.othersComments = new ArrayList<>();
        this.visibility = true;
    }

    public Comment(Discipline discipline, Usuario usuario, String comment) {
        this.id = new UserToDiscipline(discipline.getId(), usuario.getEmail());
        this.discipline = discipline;
        this.user = usuario;
        this.comment = comment;
        this.principalComment = null;
        this.othersComments = new ArrayList<>();
        this.visibility = true;
    }

    public Comment(Discipline discipline , Usuario usuario, String comment, Comment principalComment) {
        this(discipline, usuario, comment);
        this.principalComment = principalComment;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public String getComment() {
        return comment;
    }

    public List<Comment> getOthersComments() {
        return othersComments;
    }

    public Comment getPrincipalComment() {
        return principalComment;
    }

    public Usuario getUser() {
        return user;
    }

    public UserToDiscipline getId() {
        return id;
    }

    //métodos setters


    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public void setId(UserToDiscipline id) {
        this.id = id;
    }

    public void setOthersComments(List<Comment> othersComments) {
        this.othersComments = othersComments;
    }

    public void setPrincipalComment(Comment principalComment) {
        this.principalComment = principalComment;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    //métodos usuais


    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return this.discipline.toString() + " - " + this.comment + " - " + this.user.getEmail() ;
    }


}
