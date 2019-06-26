package com.model;

import javax.persistence.*;

@Entity
@Table(name = "evalue_Disciplines")
public class Evaluation {
    @EmbeddedId
    private UserToDiscipline id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("discipline_id")
    private Discipline discipline;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("email")
    private Usuario user;

    @Column(name = "note") //nota da disciplina
    private Double evaluation;

    public Evaluation(Discipline discipline, Usuario user, Double note){
        if(discipline != null && user != null && (note >= 0 && note <= 10)){
            this.id = new UserToDiscipline(discipline.getId(),user.getEmail());
            this.discipline = discipline;
            this.evaluation = note;
            this.user = user;

        } else
            throw new RuntimeException("Parametros errados!");

    }

    //métodos gets


    public Discipline getDiscipline() {
        return discipline;
    }

    public Double getEvaluation() {
        return evaluation;
    }

    public Usuario getUser() {
        return user;
    }

    public String getEmailUser(){
        return user.getEmail();
    }

    public String getNameDiscipline(){
        return discipline.getName();
    }

    @Override
    public String toString(){
        return this.getEmailUser() + " - " + this.getNameDiscipline();
    }

    public UserToDiscipline getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }


}
