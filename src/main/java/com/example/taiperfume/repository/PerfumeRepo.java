package com.example.taiperfume.repository;

import com.example.taiperfume.entity.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfumeRepo extends JpaRepository<Perfume,Long> {

}
