package com.example.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.basic.domain.FooProperties;



@Configuration
public class TaijiConfiguration {
	
	@Bean
	public FooProperties fooProperties() {
		return new FooProperties();
	}
	
	

}
