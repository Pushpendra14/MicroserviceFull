package com.synechron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class Day03ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day03ClientApplication.class, args);
	}
}
