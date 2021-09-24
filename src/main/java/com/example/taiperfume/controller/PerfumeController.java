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

    @GetMapping("/perfumes")
    public ResponseEntity<List<Perfume>> getAllPerfumes() {
        try {
            List<Perfume> list = perfumeRepo.findAll();
            if (list.isEmpty() || list.size() == 0) {
                return new ResponseEntity<List<Perfume>>(HttpStatus.NO_CONTENT);

            }
            return new ResponseEntity<List<Perfume>>(list, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<List<Perfume>>((List<Perfume>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/perfumes/{id}")
    public ResponseEntity<Perfume> getOnePerfume(@PathVariable Long id) {
        Optional<Perfume> perfume = perfumeRepo.findById(id);

        if (perfume.isPresent()){
            return  new ResponseEntity<Perfume>(perfume.get(),HttpStatus.OK);
        }
//        return new ResponseEntity<Perfume>(HttpStatus.NOT_FOUND);
         return perfume.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/perfumes/{id}")
    public ResponseEntity<Perfume>updatePerfume(@RequestBody Perfume perfume) {

        try {
            return new ResponseEntity<Perfume>(perfumeRepo.save(perfume), HttpStatus.OK);
        } catch (Exception E) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
       @DeleteMapping("/perfumes/{id}")
    public ResponseEntity<HttpStatus>deletePerfume(@PathVariable Long id ){

        try {
            Optional<Perfume>perfume = perfumeRepo.findById(id);
            perfume.ifPresent(perfumeRepo::delete);
            return  new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);

        }catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

       }
    }
