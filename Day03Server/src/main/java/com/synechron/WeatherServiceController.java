package com.synechron;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherServiceController {

	@GetMapping("/weather/{city}")
	public String getCurrentTemperature(@PathVariable String city) {
		String message = "Temperature of " + city + " is " + (Math.random() * 100);
		return message;
	}
}
