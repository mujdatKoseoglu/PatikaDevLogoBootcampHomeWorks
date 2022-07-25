package com.movie.controller;

import com.movie.model.Movie;
import com.movie.model.User;
import com.movie.service.MovieService;
import com.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/create")
    public String createMovie(@RequestBody Movie movieRequest){
        return movieService.createMovie(movieRequest);
    }

    @GetMapping("/{idRequest}")
    public Movie getByIdMovie(@PathVariable Integer idRequest){
        return movieService.getByIdMovie(idRequest);
    }

    @PutMapping("/{idRequest}")
    public Movie updateMovie(@PathVariable Integer idRequest, @RequestBody Movie movieRequest){
        return movieService.updateMovie(idRequest,movieRequest);
    }

    @DeleteMapping("/{idRequest}")
    public Movie deleteMovie(@PathVariable Integer idRequest){

        return movieService.deleteUser(idRequest);
    }

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }
}

