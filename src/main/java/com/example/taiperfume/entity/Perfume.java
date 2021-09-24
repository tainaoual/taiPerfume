package com.example.taiperfume.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Perfume)) return false;
//        Perfume perfume = (Perfume) o;
//        return getId().equals(perfume.getId()) && getName().equals(perfume.getName()) && getBrand().equals(perfume.getBrand()) && getStore().equals(perfume.getStore());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getName(), getBrand(), getStore());
//    }
}
