package com.example.apiculture;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Validated
public class GpsItem {
	@JsonProperty("externalIp")
    private String externalIp;

	@JsonProperty("city")
    private String city;

	@JsonProperty("country")
    private String country;

    public GpsItem() {
        this.setExternalIp();
        this.setLocation();
    }

    public void setExternalIp(){
        String ip = null;
		try{
            URL url = new URL("http://checkip.amazonaws.com"); // Returns the IP in a single line
            BufferedReader in = new BufferedReader(new InputStreamReader(
                            url.openStream()));

            ip = in.readLine();
		} catch (Exception e){
            System.out.println("Imposible obtener ip: " + e);
        }

        this.externalIp = ip;
	}

    /**
     * Locate the server from its public IP address using GeoLite IP-location database.
     */
    public void setLocation(){
        try{
            File database = new File(getClass().getClassLoader().getResource("static/GeoLite2-City.mmdb").getFile());
            DatabaseReader dbReader = new DatabaseReader.Builder(database).build();
            InetAddress ipAddress = InetAddress.getByName(this.externalIp);
            CityResponse response = dbReader.city(ipAddress);
                
            this.country = response.getCountry().getName();
            this.city = response.getCity().getName();
        } catch (Exception e){
            System.out.println("Imposible encontrar el archivo de BD");
        }
            
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setCountry(String country){
        this.country = country;
    }

    @Schema(example = "Madrid", required = true)
	@NotNull
    public String getCity(){
        return this.city;
    }

    @Schema(example = "Spain", required = true)
	@NotNull
    public String getCountry(){
        return this.country;
    }

    @Schema(example = "Spain", required = true)
	@NotNull
    public String getExternalIp(){
        return this.externalIp;
    }

    
}