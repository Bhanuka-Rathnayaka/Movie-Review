package com.project.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewDao;

    @Autowired
    private MongoTemplate mongoTemplate;//impleteb complex operation that cant done by repository

    //service for add review
    public Review creteReview(String reviewBody,String imdbId){
        Review review = reviewDao.insert(new Review(reviewBody));

        //associate review with related movie
        mongoTemplate.update(Movies.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(reviewBody))
                .first();

        return review;

    }
}
