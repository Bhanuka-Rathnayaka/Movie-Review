package com.project.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service//business logic
public class MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;


    //service for get all movie
    public List<Movies>allMovies(){
      return moviesRepository.findAll();
    }

    //service for get movie by imdb id
    public Optional<Movies> singleMovie(String imdbId){
        return moviesRepository.findMoviesByImdbId(imdbId);
    }


}
