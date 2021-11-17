package com.example.Ejercicio456.Ejercicio3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LaptopController {

    //Atributos
    private LaptopRepository laptopRepository;

    //constructores

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }


    //Crud sobre la entidad Laptop
    //Buscar todos los laptop

    /**
     * http://localhost:[port]/laptop
     */
    @GetMapping("/laptop")
    public List<Laptop> findAll(){

        return laptopRepository.findAll();
    }
}
