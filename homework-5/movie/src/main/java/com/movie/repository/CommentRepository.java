package com.movie.repository;

import com.movie.model.Comment;
import com.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Integer> {



}
