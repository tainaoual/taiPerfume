package com.example.taiperfume.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

@Table(name="tai_review")
@Entity
@Setter
@Getter
@ToString
@Component
public class Review {
    @Id
    @GeneratedValue
    private long id;
//   @ManyToOne
//    private Perfume perfume;
    @Column(name = "yearOfLaunch",nullable = false,updatable = false)
    private String yearOfLaunch;
    @Column(name = "rating",nullable = false,updatable = false)
    private String rating;
    @Column(name = "source",nullable = false,updatable = false)
    private String source;
    @Column(name = "description",nullable = false,updatable = false)
    private String description;
    @Column(name = "reviewToAdd",nullable = false,updatable = false)
    private String reviewToAdd;
    @Column(name = "brandName",nullable = false,updatable = false)
    private String brandName;
    //@ManyToMany
   // private Collection<Hashtag> hashtags;


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Review)) return false;
//        Review review = (Review) o;
//        return getId() == review.getId() && Objects.equals(getPerfume(), review.getPerfume()) && Objects.equals(getYearOfLaunch(), review.getYearOfLaunch()) && Objects.equals(getRating(), review.getRating()) && Objects.equals(getSource(), review.getSource()) && Objects.equals(getDescription(), review.getDescription()) && Objects.equals(getReviewToAdd(), review.getReviewToAdd()) && Objects.equals(getBrandName(), review.getBrandName());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getPerfume(), getYearOfLaunch(), getRating(), getSource(), getDescription(), getReviewToAdd(), getBrandName());
//    }

    public static void setId(int i) {
    }
}
