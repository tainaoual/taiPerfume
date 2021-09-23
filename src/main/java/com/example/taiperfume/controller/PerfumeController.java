package com.example.taiperfume.controller;

import com.example.taiperfume.entity.Perfume;
import com.example.taiperfume.repository.PerfumeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Optional;


@RestController
public class PerfumeController {

    private final PerfumeRepo perfumeRepo;

    public PerfumeController(PerfumeRepo perfumeRepo) {
        this.perfumeRepo = perfumeRepo;
    }

    @PostMapping("/perfumes")
    public ResponseEntity<Perfume> save(@RequestBody Perfume perfume) {
        try {
            return new ResponseEntity<>(perfumeRepo.save(perfume), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    }
