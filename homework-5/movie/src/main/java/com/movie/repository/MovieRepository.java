package com.movie.repository;

import com.movie.model.Movie;
import com.movie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Integer> {


}
