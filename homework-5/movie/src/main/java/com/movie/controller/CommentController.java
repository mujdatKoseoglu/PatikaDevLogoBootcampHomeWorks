package com.movie.controller;

import com.movie.model.Comment;
import com.movie.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/create")
    public String createComment(@RequestBody Comment commentRequest){
        return commentService.createComment(commentRequest);
    }

    @GetMapping("/{idRequest}")
    public Comment getById(@PathVariable Integer idRequest){
        return commentService.getById(idRequest);
    }


    @DeleteMapping("/delete/{idRequest}")
    public Comment deleteComment(@PathVariable Integer idRequest){
        return commentService.deleteComment(idRequest);
    }

}

