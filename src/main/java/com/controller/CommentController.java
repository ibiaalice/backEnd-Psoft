package com.controller;

import com.model.Comment;
import com.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({ "/v1/comments" })
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Comment> findById(@PathVariable long id) {
        Comment comment = commentService.findById(id);
        if (comment == null) {
            throw new RuntimeException("Comentário nao encontrado");
        }

        return new ResponseEntity<Comment>(comment, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    @ResponseBody
    public ResponseEntity<Comment> create(@RequestBody Comment comment) {
        Comment newComment = commentService.findById(comment.getId());
        if (newComment == null) {
            throw new RuntimeException("Comentário não encontrado");
        }
        commentService.create(newComment);
        return new ResponseEntity<Comment>(newComment, HttpStatus.CREATED);
    }



}
