package com.movie.service;

import com.movie.model.Comment;
import com.movie.model.Movie;
import com.movie.model.User;
import com.movie.repository.CommentRepository;
import com.movie.repository.MovieRepository;
import com.movie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;


    public String createComment(Comment commentRequest) {
        Integer movieId = commentRequest.getMovie().getId();
        Movie movie = getMovie(movieId);
        User user = movie.getUser();
        //kayıt olduysan yorum yapabilirsin
        if (user.getIsPremium()){
            commentRepository.save(commentRequest);
            return "saved successfully";
            //kayıt olmadıysan yorum yapamazsın
        } else {
            return "for comment please register";
        }

    }

    @Async
    public Movie getMovie(Integer movieId) {
        return movieRepository.getById(movieId);
    }

    public Comment getById(Integer idRequest) {
        Comment comment1 = commentRepository.findById(idRequest).get();
        return comment1;
    }


    public Comment deleteComment(Integer idRequest) {
        Comment comment1 = commentRepository.findById(idRequest).get();
        commentRepository.delete(comment1);
        return comment1;
    }

}
