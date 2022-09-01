package com.example.apiculture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApicultureApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApicultureApplication.class, args);
	}

	@GetMapping("/")
	public String index(@RequestParam(value="name", defaultValue="anonymous") String name){
		return "Hello, " + name + "!";
	}

}
