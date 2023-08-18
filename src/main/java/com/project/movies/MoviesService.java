package com.project.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Service
public class MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

    @GetMapping
    public List<Movies>allMovies(){
      return moviesRepository.findAll();
    }
}
