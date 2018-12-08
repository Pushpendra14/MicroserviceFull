package com.synechron;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class CityInfoController {

	@Value("${weatherservice.base_url}")
	private String weatherServiceBaseUrl;
	
	private RestTemplate restTemplate = new RestTemplate();
	private Map<String, String> cache = new HashMap<>();
	
	@GetMapping("/weatherinfo/{city}")
	@HystrixCommand(fallbackMethod="getWeatherInfoFromCache", commandProperties = {
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", 
					value="5000")	
	})
	public String getWeatherInfoFromServer(@PathVariable String city) {
		System.out.println("*******calling getWeatherInfoFromServer");
		String url = weatherServiceBaseUrl + "/" + city;
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		String output = responseEntity.getBody();
		cache.put(city, output);
		return output;
	}
	
	public String getWeatherInfoFromCache(String city) {
		System.out.println("-----calling getWeatherInfoFromCache");
		String message = cache.get(city);
		if(message == null) {
			message = "Oops! WeatherService may be down temporarily";
		}
		else {
			message = "From Cache: " + message;
		}
		
		return message;
	}
	
	
	
	
	
	
	
	
	
	
}
