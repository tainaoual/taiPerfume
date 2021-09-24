package com.example.taiperfume.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table(name="tai_perfume")
@Entity
@Setter
@Getter
@ToString
public class Perfume {
    @Id
    @GeneratedValue
    private  Long id;
    @Column(name = "name")
    private  String name;
    @Column(name="brand")
    private  String brand;
    @Column(name="store")
    private  String store;



}
