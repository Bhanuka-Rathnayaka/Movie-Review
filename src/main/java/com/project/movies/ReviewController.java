package com.project.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;


    @PostMapping
    public ResponseEntity<Review> createReview (@RequestBody Map<String,String> payload){//what ever get from @RequestBody its map to string ket and string value also map as payload
        //return new ResponseEntity<Review>(reviewService.creteReview(payload.get("reviewBody"),payload.get("imdbId")), HttpStatus.CREATED);

        Review review = reviewService.creteReview(payload.get("reviewBody"),payload.get("imdbId"));

        if (review != null){
            return new ResponseEntity<>(review,HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //
        }
    }
}
