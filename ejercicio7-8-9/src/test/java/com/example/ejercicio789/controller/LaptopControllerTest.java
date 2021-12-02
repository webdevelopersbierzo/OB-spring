package com.example.ejercicio789.controller;

import com.example.ejercicio789.entities.Laptop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    // tenemos que crear un objeto
    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort // inyecta el puerto http
    private int port;
    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response =
            testRestTemplate.getForEntity("/api/laptops", Laptop[].class); // pasamos un array de Book

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(200,response.getStatusCodeValue());

        List<Laptop> laptops = Arrays.asList(response.getBody());
        System.out.println(laptops.size());

    }

    @Test
    void create() {
        // preparacion minima para enviar cabeceras json
        HttpHeaders headers = new HttpHeaders(); // Enviamos las cabeceras
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "manufacture": "test",
                    "model": "458hm95",
                    "price": 485.5,
                    "touch": true
                }
                """;
        // pasamos la request
        HttpEntity<String> request = new HttpEntity<>(json,headers); // creamos la peticion json
        // ejecutamos la peticion
        ResponseEntity<Laptop> response =
                testRestTemplate.exchange("/api/books", HttpMethod.POST, request, Laptop.class);

        Laptop result = response.getBody();
    }
/*
    @Test
    void findOneById() {
        ResponseEntity<Laptop[]> response =
            testRestTemplate.getForEntity("/api/laptop/32", Laptop[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200,response.getBody());
        assertEquals(32,response.getBody());

    }

    @Test
    void update() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void deleteOneById() {
    }*/
}