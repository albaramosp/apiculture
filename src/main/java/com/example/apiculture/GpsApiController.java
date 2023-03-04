package com.example.apiculture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GpsApiController implements GpsApi {
	private final GpsItem gps = null;
	
	public String getExternalIp(){
		GpsItem gps = null;

		if (this.gps != null) {
			gps = this.gps;
		} else {
			gps = new GpsItem();
		}
		return gps.getExternalIp();
	}

	public String getLocation(){
		GpsItem gps = null;

		if (this.gps != null) {
			gps = this.gps;
		} else {
			gps = new GpsItem();
		}

		return gps.getCity() + ", " + gps.getCountry();
	}

	

}
