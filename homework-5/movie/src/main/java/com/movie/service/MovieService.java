package com.movie.service;

import com.movie.dto.EmailDto;
import com.movie.model.Movie;
import com.movie.model.User;
import com.movie.repository.MovieRepository;
import com.movie.repository.UserRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public String createMovie(Movie movieRequest) {
        Integer userId = movieRequest.getUser().getId();
        User user = getUser(userId);
        //ücretli üye ya da ücretli olmadan 3'ten az eklemişse kayıt işlemi yapılır
        if (user.getIsPremium() || (!user.getIsPremium() && user.getMovieList().size() < 3)) {
            movieRepository.save(movieRequest);
            //film eklenince email göndersin
            //rabbitTemplate.convertAndSend("${rabbitmq.queue}", new EmailDto(user.getEmail(),"Email","new movie added"));
            return "Movie added";
        //ya da ücretli olmadan 3'ten fazla film eklemeye çalışıyorsa kayıt işlemi yapılmaz
        } else {
            return "more than three can't be added";
        }
    }
    //yukarıda cevabını beklemesi için metotdan çağırdık
    @Async
    public User getUser(Integer userId) {
        return userRepository.getById(userId);
    }

    public Movie getByIdMovie(Integer idRequest) {
        Movie movie1 = movieRepository.findById(idRequest).get();
        return movie1;
    }

    public Movie updateMovie(Integer idRequest, Movie movieRequest) {
        Movie movie1 = movieRepository.findById(idRequest).get();
        movie1.setName(movieRequest.getName());
        movieRepository.save(movie1);
        return movie1;
    }

    public Movie deleteUser(Integer idRequest) {
        Movie movie1 = movieRepository.findById(idRequest).get();
        movieRepository.delete(movie1);
        return movie1;
    }
    //eklenen bütün filmler listelenebilir
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

}
