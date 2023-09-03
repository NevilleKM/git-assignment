package com.assignment.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TestAPI {
	
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI="https://weather.visualcrossing.com";
		RestAssured.basePath="/VisualCrossingWebServices/rest/services";
	}
	
	@Test
	public void statusCodeVerification() {
		String city = "Pune";
		
		given()
			.param("unitGroup", "metric")
			.param("key", "T4TTPGCG3AD5Q2LME8PNJATRY")
			.queryParam("contentType", "json")
	   .when()
			.get("/timeline/"+ city)
	   .then()	
		 	.statusCode(200);
	}

}
