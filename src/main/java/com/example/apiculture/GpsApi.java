package com.example.apiculture;

import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "gps")
public interface GpsApi {

	@Operation(description = "Get the public IP of the server", 
			   operationId = "getExternalIp", 
			   summary = "Get the public IP of the server", 
			   tags = {"GPS",})
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "ok") })
	@GetMapping("/server_ip")
	String getExternalIp();

	@Operation(description = "Get the city and country of the server", 
			   operationId = "getLocation", 
			   summary = "Get the city and country of the server", 
			   tags = {"GPS",})
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "ok") })
	@GetMapping("/server_location")
	String getLocation();
}
