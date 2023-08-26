package com.project.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoviesRepository extends MongoRepository<Movies,ObjectId> {
    //implement find movie by imbd id
    Optional<Movies> findMoviesByImdbId(String imdbId);
}
