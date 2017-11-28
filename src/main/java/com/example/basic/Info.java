package com.example.basic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("myInfo")
public class Info {
	@Value("${info.huangrui.name}")
	private String appName;

	@Value("${info.huangrui.phone}")
	private String phone;
	
	@Value("${info.huangrui.email}")
	private String email;
	
	
	@Value("${info.huangrui.age}")
	private int age;
	
	

}
