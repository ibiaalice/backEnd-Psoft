package com.dao;

import com.model.Evaluation;
import com.model.UserToDiscipline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface EvaluationDAO<T,ID extends Serializable> extends JpaRepository<Evaluation, UserToDiscipline> {

    Evaluation save(Evaluation evaluation);

    //void delete(Evaluation evaluation);

}
