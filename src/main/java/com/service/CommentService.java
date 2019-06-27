package com.service;

import com.dao.CommentDAO;
import com.model.Comment;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class CommentService {
    private final CommentDAO commentDAO;

    public CommentService(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    public Comment create(long reference, String text, String email) {
        Comment newComment = new Comment(reference, text, email);

        return this.commentDAO.save(newComment);

    }

    public void delete(long id) {
        Comment comment = commentDAO.findById(id);
        if(comment == null) throw new RuntimeException("Comentário não existe");
        commentDAO.delete(comment);
    }

    public  void logicDelete(long id){
        Comment comment = commentDAO.findById(id);
        if(comment == null) throw new RuntimeException("Comentário não existe");
        comment.setDeleted(true); //seta a variavel deletada para true
        commentDAO.save(comment); //atualiza no banco de dados!
    }

    public Date getDate(long id){
        Comment comment = commentDAO.findById(id);
        if(comment == null) throw new RuntimeException("Comentário não existe");
        return comment.getData();
    }

    public Comment findById(long id){
        Comment comment = this.commentDAO.findById(id);
        if(comment == null) throw new RuntimeException("Comentário não existe");
        return  comment;
    }

    public List<Comment> findByReference(long id){
        List comments = commentDAO.findByReference(id);
        if(comments.size() == 0) throw new RuntimeException("Comentários não existem nessa referencia!");
        return comments;
    }


    public void create(Comment newComment) {
        commentDAO.save(newComment);
    }
}
