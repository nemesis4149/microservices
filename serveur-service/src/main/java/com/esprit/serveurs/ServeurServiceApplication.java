package com.esprit.serveurs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServeurServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServeurServiceApplication.class, args);
	}
}
