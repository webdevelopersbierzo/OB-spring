package com.ejercicio1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        // Instanciamos el contenedor beans
        ApplicationContext context = new ClassPathXmlApplicationContext(("beans.xml"));
        Saludo saludamos = (Saludo) context.getBean("saludo");

        String texto = saludamos.imprimirSaludo();
        System.out.println(texto);
    }

}
