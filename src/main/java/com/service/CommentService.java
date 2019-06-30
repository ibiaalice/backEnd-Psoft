package com.service;

import com.dao.CommentDAO;
import com.model.Comment;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Método de serviço do Objeto Comment
 */
@Service
public class CommentService {
    private final CommentDAO commentDAO;

    /**
     * Construtor da classe
     * @param commentDAO
     */
    public CommentService(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    /**
     * Método da criação de Comment
     * @param reference referencia ao objeto dono do Comment
     * @param text texto do Comment
     * @param email email do Comment
     * @return retorna uma copia do Comment criado
     */
    public Comment create(long reference, String text, String email) {
        Comment newComment = new Comment(reference, text, email);

        return this.commentDAO.save(newComment);
    }

    /**
     * Método de criação de Comment
     * @param newComment novo Comment a ser adicionado
     */
    public void create(Comment newComment) {
        commentDAO.save(newComment);
    }

    /**
     * Método de exclusão verdadeira do Comment
     * @param id id do Comment a ser excluido
     */
    public void delete(long id) {
        Comment comment = commentDAO.findById(id);
        if(comment == null) throw new RuntimeException("Comentário não existe");
        commentDAO.delete(comment);
    }

    /**
     * Método da exclusão lógica do Comment
     * @param id recebe o id para ser excluido
     */
    public  void logicDelete(long id){
        Comment comment = commentDAO.findById(id);
        if(comment == null) throw new RuntimeException("Comentário não existe");
        comment.setDeleted(true); //seta a variavel deletada para true
        commentDAO.save(comment); //atualiza no banco de dados!
    }

    /**
     * Método de procura por Comment por ID
     * @param id id do Comment procurado
     * @return retorna uma cópia do comment procurado
     */
    public Comment findById(long id){
        Comment comment = this.commentDAO.findById(id);
        if(comment == null) throw new RuntimeException("Comentário não existe");
        return  comment;
    }

    /**
     * Método de procura por Comment por Referencia
     * @param id id de referencia
     * @return retorna uma lista com comentários que possuem a mesma referencia
     */
    public List<Comment> findByReference(long id) throws NotFoundException {
        List comments = commentDAO.findByReference(id);
        if(comments.size() == 0) throw new NotFoundException("Comentários não existem nessa referencia!");
        return comments;
    }



}
