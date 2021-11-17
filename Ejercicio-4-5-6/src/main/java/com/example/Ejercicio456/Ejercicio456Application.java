package com.example.Ejercicio456;

import com.example.Ejercicio456.Ejercicio2.Laptop;
import com.example.Ejercicio456.Ejercicio2.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio456Application {

	public static void main(String[] args) {

		ApplicationContext context =  SpringApplication.run(Ejercicio456Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		// Creamos un lapto

		Laptop laptop1 = new Laptop(null,"Toshiba","567hx46",4,"Windows 11");
		Laptop laptop2 = new Laptop(null,"Lenovo","85ki365",8,"Windows 11");
		repository.save(laptop1);
		repository.save(laptop2);




	}

}
