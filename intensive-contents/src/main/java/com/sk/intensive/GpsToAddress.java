package com.sk.intensive;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;


@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class GpsToAddress {
	String latitude;
	String longitude;
	String regionAddress;

	public String gpsToAddress(String latitude, String longitude) throws Exception {
		this.latitude = latitude;
		this.longitude = longitude;
		this.regionAddress = getRegionAddress(getJSONData(getApiAddress()));
		
		return regionAddress;
	}

	private String getApiAddress() {
		String apiURL = "https://maps.googleapis.com/maps/api/geocode/json?"
				+ "key=AIzaSyB4px7FZi3qh7aUY6XM5SCdlOcMC09e89w"
				+ "&latlng="+ latitude + "," + longitude 
				+ "&language=ko";
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ apiURL @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(apiURL);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		return apiURL;
	}

	private String getJSONData(String apiURL) throws Exception {
		String jsonString = new String();
		String buf;
		URL url = new URL(apiURL);
		URLConnection conn = url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				conn.getInputStream(), "UTF-8"));
		while ((buf = br.readLine()) != null) {
			jsonString += buf;
		}
		return jsonString;
	}

	private String getRegionAddress(String jsonString) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ jsonString @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("jsonString => "+jsonString);
		ObjectMapper mapper = new ObjectMapper();
        JsonNode array =  mapper.readValue(jsonString, JsonNode.class);
        JsonNode object = array.get("results").get(0);
        System.out.println("array.get(\"results\").get(0) => "+object);
        String address = object.get("formatted_address").textValue();
        System.out.println("object.get(\"formatted_address\").textValue() => "+address);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        
        return address; 
	}
}
