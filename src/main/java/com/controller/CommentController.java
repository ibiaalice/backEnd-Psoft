package com.controller;

import com.model.Comment;
import com.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(value="Classe controladora do objeto Comment")
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

    @ApiOperation(value="Método de rota de pesquisa por ID")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Comment> findById(@PathVariable long id) {
        Comment comment = commentService.findById(id);
        if (comment == null) {
            throw new RuntimeException("Comentário nao encontrado");
        }

        return new ResponseEntity<Comment>(comment, HttpStatus.OK);
    }

    @ApiOperation(value="Método de rota de criação do objeto Comment")
    @PostMapping(value="/create")
    @ResponseBody
    public ResponseEntity<Comment> create(@RequestBody Comment comment) {
      /*  Comment newComment = commentService.findById(comment.getId());
        if (newComment == null) {
            throw new RuntimeException("Comentário não encontrado");
        }*/
        commentService.create(comment);
        return new ResponseEntity<Comment>(comment, HttpStatus.CREATED);
    }

    @ApiOperation(value="Método de rota de exclusão lógica do objeto Comment")
    @GetMapping(value="/deleted/{id}")
    @ResponseBody
    public ResponseEntity<Comment> deleted(@PathVariable long id){
        Comment comment = commentService.findById(id);

        comment.setDeleted(true);
        commentService.create(comment); //atualiza o comentário

        return new ResponseEntity<Comment>(comment, HttpStatus.ACCEPTED);
    }

    @ApiOperation(value="Método com rota de pesquisa de Comments pela referência")
    @GetMapping(value="/find/{reference}")
    @ResponseBody
    public ResponseEntity<List<Comment>> findByReference(@PathVariable long reference) throws NotFoundException {
        List idReference = commentService.findByReference(reference);

        return new ResponseEntity<List<Comment>>(idReference, HttpStatus.OK);
    }




}
