package com.dao;

import com.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface CommentDAO<T, ID extends Serializable> extends JpaRepository<Comment, Long> {
    Comment save(Comment comment);

    void delete(Comment comment);

    Comment findById(long id);

    @Query(value="Select * from comment c where c.reference = :preference", nativeQuery = true)
    List<Comment> findByReference(@Param("preference") Long id);

}
