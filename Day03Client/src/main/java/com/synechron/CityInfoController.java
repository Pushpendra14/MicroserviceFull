package com.synechron;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CityInfoController {

	@Value("${weatherservice.base_url}")
	private String weatherServiceBaseUrl;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("/weatherinfo/{city}")
	public String getWeatherInfoFromServer(@PathVariable String city) {
		String url = weatherServiceBaseUrl + "/" + city;
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		return responseEntity.getBody();
	}
}
