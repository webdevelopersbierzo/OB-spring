package com.example.ejercicio789.controller;


import com.example.ejercicio789.entities.Laptop;
import com.example.ejercicio789.repository.LaptopRepository;
import org.hibernate.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

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
    // ENCONTRAR UN LAPTOP POR ID

    /**
     * Buscamos mediante el parametro de url el id en base de datos
     * @param id  parametro pasado en url
     * @return ResponseEntity
     */
    @GetMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> laptopOpt =  laptopRepository.findById(id);
        if(laptopOpt.isPresent()){
            return ResponseEntity.ok(laptopOpt.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
