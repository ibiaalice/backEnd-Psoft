package com.dao;

import com.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Classe Repositorio do Objeto Comments
 * @param <T> Objeto T
 * @param <ID> ID da interface
 */
@Repository
public interface CommentDAO<T, ID extends Serializable> extends JpaRepository<Comment, Long> {
    /**
     * Método que salva o objeto Comment no banco de dados
     * @param comment recebe o Comment a ser salvo
     * @return retorna o Comments após salvo no repository
     */
    Comment save(Comment comment);

    /**
     * Método que deleta o objeto Comment no banco de dados
     * @param comment recebe o Comment a ser deletado
     */
    void delete(Comment comment);

    /**
     * Método de pesquisa por ID com Comment
     * @param id o id do Comment a ser procurado
     * @return retorna um Comment com o id procurado
     */
    Comment findById(long id);

    /**
     * Método de pesquisa por referência
     * @param id referência do Comment
     * @return retorna uma lista com as mesmas referência
     */
    @Query(value="Select * from comment c where c.reference = :preference", nativeQuery = true)
    List<Comment> findByReference(@Param("preference") Long id);

}
