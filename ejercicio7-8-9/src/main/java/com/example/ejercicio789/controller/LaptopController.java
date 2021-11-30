package com.example.ejercicio789.controller;


import com.example.ejercicio789.entities.Laptop;
import com.example.ejercicio789.repository.LaptopRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LaptopController {
    // Atributos

    private LaptopRepository laptopRepository;
    // constructores
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    // BUSCAR TODOS LOS LAPTOP
    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }
}
