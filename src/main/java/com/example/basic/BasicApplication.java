package com.example.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.ServletRequestHandledEvent;

import com.example.basic.domain.FooProperties;





@SpringBootApplication
public class BasicApplication {
	private static final Logger log = LoggerFactory.getLogger(BasicApplication.class);
	
	@Autowired
	private CounterService counterService;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BasicApplication.class, args);
		
//		Info info = context.getBean(Info.class);
//		System.out.println(info.getAge());
		
		FooProperties foo = context.getBean(FooProperties.class);
		System.out.println(foo);
		foo.setEnabled(false);
		
		System.out.println(foo);
		
	}
	//	访问http://localhost:8080/em/health能看到是否能访问互联网
	
	@Bean
	public HealthIndicator myHealth() {
		return()->{
			return Health.up().build();
			
		};
	}
	
	
	
	@Bean
	public ApplicationListener<ApplicationEvent> xyzListener() {
		final String XYZ_URL = "/xyz";

		return (ApplicationEvent event) -> {
			if (event instanceof ServletRequestHandledEvent) {
				ServletRequestHandledEvent e = (ServletRequestHandledEvent) event;
				if (e.getRequestUrl().equals(XYZ_URL))
					counterService.increment("xyz.hits");
			}
		};
	}
	
	
}
