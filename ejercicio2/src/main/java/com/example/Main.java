package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        // Instanciamos un objeto beans
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        NotificationService notificationService = (NotificationService) context.getBean("notificationService");


        UserService servicio = (UserService) context.getBean("userService");

        System.out.println(servicio.notificationService.imprimirSaludo());

    }
}
