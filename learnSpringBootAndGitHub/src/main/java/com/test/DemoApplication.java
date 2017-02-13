package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//@EnableWebMvc
public class DemoApplication {


   public static void main(String[] args) {
      SpringApplication.run(DemoApplication.class, args);
   }
}