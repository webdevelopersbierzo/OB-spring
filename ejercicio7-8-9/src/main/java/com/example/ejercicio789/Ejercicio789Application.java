package com.example.ejercicio789;

import com.example.ejercicio789.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio789Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Ejercicio789Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);
	}

}
