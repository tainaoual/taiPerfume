package com.example.taiperfume.controller;

import com.example.taiperfume.entity.Perfume;
import com.example.taiperfume.entity.Review;
import com.example.taiperfume.repository.PerfumeRepo;
import com.example.taiperfume.repository.ReviewRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class ReviewController {
    private final ReviewRepo reviewRepo;

    public ReviewController(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @PostMapping("/reviews")
    public ResponseEntity<Review> save(@RequestBody Review review) {
        try {
            return new ResponseEntity<>(reviewRepo.save(review), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews() {
        try {
            List<Review> list = reviewRepo.findAll();
            if (list.isEmpty() || list.size() == 0) {
                return new ResponseEntity<List<Review>>(HttpStatus.NO_CONTENT);

            }
            return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<List<Review>>((List<Review>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<Review> getOneReview(@PathVariable Long id) {
        Optional<Review> review = reviewRepo.findById(id);

        if (review.isPresent()){
            return  new ResponseEntity<Review>(review.get(),HttpStatus.OK);
        }
//
        return review.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/reviews/{id}")
    public ResponseEntity<Review>updateReview(@RequestBody Review review) {

        try {
            return new ResponseEntity<Review>(reviewRepo.save(review), HttpStatus.OK);
        } catch (Exception E) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<HttpStatus>deleteReview(@PathVariable Long id ){

        try {
            Optional<Review>review= reviewRepo.findById(id);
            review.ifPresent(reviewRepo::delete);
            return  new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);

        }catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
