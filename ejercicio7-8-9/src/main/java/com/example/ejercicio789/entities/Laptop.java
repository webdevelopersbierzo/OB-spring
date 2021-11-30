package com.example.ejercicio789.entities;

import javax.persistence.*;

@Entity
@Table(name="laptops")
public class Laptop {

    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacture;
    private String model;
    private Double price;
    private Boolean touch;

    // constructores

    public Laptop() {
    }

    public Laptop(Long id, String manufacture, String model, Double price, Boolean touch) {
        this.id = id;
        this.manufacture = manufacture;
        this.model = model;
        this.price = price;
        this.touch = touch;
    }
    // getter and setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getTouch() {
        return touch;
    }

    public void setTouch(Boolean touch) {
        this.touch = touch;
    }
}
