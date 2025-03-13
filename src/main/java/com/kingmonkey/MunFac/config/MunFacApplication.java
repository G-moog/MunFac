package com.kingmonkey.MunFac.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kingmonkey.MunFac"})
public class MunFacApplication {

	public static void main(String[] args) {
		SpringApplication.run(MunFacApplication.class, args);
	}

}
