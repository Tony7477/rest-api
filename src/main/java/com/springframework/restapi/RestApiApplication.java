package com.springframework.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(RestApiApplication.class, args
		);
	}

}
