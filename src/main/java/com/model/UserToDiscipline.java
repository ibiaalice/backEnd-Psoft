package com.model;

import javax.persistence.Column;
import java.io.Serializable;

public class UserToDiscipline implements Serializable {
    @Column(name = "discipline_id")
    private Long disciplineId;

    @Column(name = "email")
    private String email;

    public UserToDiscipline() {

    }

    public UserToDiscipline(long id, String email){
        this.email = email;
        this.disciplineId = id;
    }

    public Long getDisciplineId() {
        return disciplineId;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return this.getEmail() + " - " + " ID disciplina: " + getDisciplineId();
    }


}
