package com.example.taiperfume.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Table(name="tai_perfume")
@Entity
@Setter
@Getter
@ToString
@Component
public class Perfume {
    @Id
    @GeneratedValue
    private  Long id;
    @Column(name = "name",nullable = false,updatable = false)
    private  String name;
    @Column(name="brand",nullable = false,updatable = false)
    private  String brand;
    @Column(name="store",nullable = false,updatable = false)
    private  String store;


    public static void setId(int i) {
    }
}
