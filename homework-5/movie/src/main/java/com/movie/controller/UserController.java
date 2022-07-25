package com.movie.controller;

import com.movie.model.Movie;
import com.movie.model.User;
import com.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String createUser(@RequestBody User userRequest) {
        return userService.createUser(userRequest);
    }

    @GetMapping("/{idRequest}")
    public User getByIdUser(@PathVariable Integer idRequest) {
        return userService.getByIdUser(idRequest);
    }

    @PutMapping("/{idRequest}")
    public User updateUser(@PathVariable Integer idRequest, @RequestBody User userRequest) {
        return userService.updateUser(idRequest, userRequest);
    }

    @DeleteMapping("/{idRequest}")
    public User deleteUser(@PathVariable Integer idRequest) {
        return userService.deleteUser(idRequest);
    }

    @GetMapping("/myMovies/{idRequest}")
    public List<Movie> getListMovies(@PathVariable Integer idRequest) {
        return userService.getListMovies(idRequest);
    }

}
