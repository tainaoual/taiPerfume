package com.example.taiperfume.repository;

import com.example.taiperfume.entity.Perfume;
import com.example.taiperfume.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review,Long> {
}
