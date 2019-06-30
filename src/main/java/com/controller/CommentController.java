package com.controller;

import com.model.Comment;
import com.service.CommentService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Classe controladora do objeto Comment
 */
@RestController
@RequestMapping({ "/v1/comments" })
public class CommentController {
    private final CommentService commentService;

    /**
     * Método construtor da Classe
     * @param commentService Service do Objeto Comment
     */
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * Método de rota de pesquisa por ID
     * @param id Long que recebe o ID do Comment procurado
     * @return Uma entidade com o Objeto Comment
     */
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Comment> findById(@PathVariable long id) {
        Comment comment = commentService.findById(id);
        if (comment == null) {
            throw new RuntimeException("Comentário nao encontrado");
        }

        return new ResponseEntity<Comment>(comment, HttpStatus.OK);
    }

    /**
     * Método de rota de criação do objeto Comment
     * @param comment objeto Comment a ser criado
     * @return retorna uma cópia do Objeto criado.
     */
    @PostMapping(value = "/create")
    @ResponseBody
    public ResponseEntity<Comment> create(@RequestBody Comment comment) {
      /*  Comment newComment = commentService.findById(comment.getId());
        if (newComment == null) {
            throw new RuntimeException("Comentário não encontrado");
        }*/
        commentService.create(comment);
        return new ResponseEntity<Comment>(comment, HttpStatus.CREATED);
    }

    /**
     * Método de rota de exclusão lógica do objeto Comment
     * @param id O id do objeto a ser deletado
     * @return retorna uma cópia do Comment "deletado"
     */
    @GetMapping(value = "/deleted/{id}")
    @ResponseBody
    public ResponseEntity<Comment> deleted(@PathVariable long id){
        Comment comment = commentService.findById(id);

        comment.setDeleted(true);
        commentService.create(comment); //atualiza o comentário

        return new ResponseEntity<Comment>(comment, HttpStatus.ACCEPTED);
    }

    /**
     * Método com rota de pesquisa de Comments pela referência
     * @param reference ID de referência para a pesquisa
     * @return retorna uma lista de Comments referente ao id buscado
     */
    @GetMapping(value = "/find/{reference}")
    @ResponseBody
    public ResponseEntity<List<Comment>> findByReference(@PathVariable long reference) throws NotFoundException {
        List idReference = commentService.findByReference(reference);

        return new ResponseEntity<List<Comment>>(idReference, HttpStatus.OK);
    }




}
