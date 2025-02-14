package com.example.hsezoo;

import com.example.hsezoo.service.Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class HseZooApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        Controller controller = (Controller) context.getBean("controller");

        controller.start();
    }
}
