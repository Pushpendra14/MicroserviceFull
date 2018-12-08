package com.synechron;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${welcome}")
	private String welcome;
	
	@GetMapping("/")
	public String index() {
		return welcome;
	}
}