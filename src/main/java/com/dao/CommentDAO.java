package com.dao;

import com.model.Comment;
import com.model.UserToDiscipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;

public interface CommentDAO <T,ID extends Serializable> extends JpaRepository<Comment, Long> {
    Comment save(Comment comment);

    @Query(value = "SELECT c FROM Comment c WHERE c.id=:id")
    Comment findByIdAlternative(@Param("id") UserToDiscipline id);

    void delete(Comment comment);
}
