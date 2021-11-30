package com.example.ejercicio789.controller;


import com.example.ejercicio789.entities.Laptop;
import com.example.ejercicio789.repository.LaptopRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
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
    // GUARDAR UN LAPTOP

    /**
     *  Guarda un laptop en la base de datos por medio de json
     * @param laptop nos llega un laptop por json
     * @return nos devuelve el laptop guardado
     */
    @PostMapping("/api/laptop")
    public Laptop create(@RequestBody Laptop laptop){
        return laptopRepository.save(laptop);
    }
}
