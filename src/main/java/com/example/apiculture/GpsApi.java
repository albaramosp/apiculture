package com.example.apiculture;

import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "gps")
public interface GpsApi {

	@Operation(description = "get public ip", operationId = "getExternalIp", summary = "Get the public IP of the device from which the request is being made", tags = {
		"GPS", })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "IP retrieved") })
	@GetMapping("/ip")
	String getExternalIp();

	@Operation(description = "get the current location", operationId = "getLocation", summary = "Get the city and country from which the request is being made", tags = {
		"GPS", })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "location retrieved") })
	@GetMapping("/location")
	String getLocation();
}
