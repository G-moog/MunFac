package com.kingmonkey.munfac.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kingmonkey.munfac"})
public class MunFacApplication {
	private static ApplicationContext context;

	public static void main(String[] args) {

		context = SpringApplication.run(MunFacApplication.class, args);
		printBeanList();
	}

	public static void printBeanList() {
		String[] beans = context.getBeanDefinitionNames();
		for (String bean : beans) {
			System.out.println("Bean Definition Name: " + bean);
		}
	}
}
