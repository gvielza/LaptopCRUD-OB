package com.ejercicio456.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "laptops")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     private String marcaN;
     private Integer yearL;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marcaN;
    }

    public void setMarca(String marcaN) {
        this.marcaN = marcaN;
    }

    public Integer getYear() {
        return yearL;
    }

    public void setYear(Integer yearL) {
        this.yearL = yearL;
    }

    public Laptop(Integer id, String marca, Integer year) {
        this.id = id;
        this.marcaN = marca;
        this.yearL = year;
    }

    public Laptop() {

    }
}
