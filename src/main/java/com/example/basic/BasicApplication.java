package com.example.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BasicApplication.class, args);
		
		Info info = context.getBean(Info.class);
		System.out.println(info.getAge());
	}
}
