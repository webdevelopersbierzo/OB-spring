package com.example.ejercicio789.controller;


import com.example.ejercicio789.entities.Laptop;
import com.example.ejercicio789.repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    @Value("${app.message}")
    String message;
    // Atributos

    private LaptopRepository laptopRepository;
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);
    // constructores
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    // BUSCAR TODOS LOS LAPTOP
    @GetMapping("/api/laptops")

    public List<Laptop> findAll(){

        System.out.println(message);
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
    @ApiOperation("Buscar un libro por clave primaria id Long")
    public ResponseEntity<Laptop> findOneById(@ApiParam("Clave primaria tipo Long") @PathVariable Long id){
        Optional<Laptop> laptopOpt =  laptopRepository.findById(id);
        if(laptopOpt.isPresent()){
            return ResponseEntity.ok(laptopOpt.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    // Actualizar un Laptop existente

    /**
     * Actualidar un laptop por json
     * @param laptop
     * @return
     */
    @PutMapping("/api/laptop")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId() == null){ // si no existe
            log.warn ("trying to update a non existent laptop");
            return ResponseEntity.badRequest().build();
        }
        if(!laptopRepository.existsById(laptop.getId())){
            log.warn("trying  to update a non existent laptop");
            return ResponseEntity.notFound().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);

    }

    /**
     *  Borrar un laptop de la base de datos
     *  @return
     */
    @ApiIgnore
    @DeleteMapping("/api/laptop")
    public ResponseEntity<Laptop> deleteAll(){
        log.warn("REST request for delete laptop all");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

    /**
     * Borra un laptop de la base de datos
     * @param id numero de resgistro en base de datos
     * @return ResponseEntity
     */
    @DeleteMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> deleteOneById(@PathVariable Long id){
        if(!laptopRepository.existsById(id)){
            log.warn("trying to update a non existent laptop");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);;
        return ResponseEntity.ok().build();
    }
}
