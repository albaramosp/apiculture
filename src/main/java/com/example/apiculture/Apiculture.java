package com.example.apiculture;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@SpringBootApplication
public class Apiculture {

	public static void main(String[] args) {
		SpringApplication.run(Apiculture.class);
	}

	@Operation(description = "get a simple string", operationId = "getString", summary = "Get a string message", tags = {
		"APIculture", })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "ok") })
	@GetMapping("/message")
	String getMessage(){
		return "Hello!";
	}

	@Operation(description = "get a random number", 
			   operationId = "getRandomNumber", 
			   summary = "Get a random number", 
			   tags = {"APIculture",})
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "ok") })
	@GetMapping("/random_number")
	Integer getRandomNumber(@RequestParam(name="upperBound", 
										  required=false) String upperBound){
		if (upperBound != null){
			return new Random().nextInt(Integer.valueOf(upperBound));
		}

		return new Random().nextInt();
		
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components())
				.info(new Info().title("APIculture")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}


}
