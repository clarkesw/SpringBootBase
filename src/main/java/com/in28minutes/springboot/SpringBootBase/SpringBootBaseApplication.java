package com.in28minutes.springboot.SpringBootBase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBaseApplication {

	public static void main(String[] args) {
            System.out.println("++++ SpringBootBaseApplication starting!!");
            SpringApplication.run(SpringBootBaseApplication.class, args);
	}
}
