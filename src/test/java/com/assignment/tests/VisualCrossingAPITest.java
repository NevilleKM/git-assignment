package com.assignment.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VisualCrossingAPITest {
	
	RequestSpecBuilder requestBuilder;
	static RequestSpecification  requestSpec;
	
	ResponseSpecBuilder responseBuilder;
	static ResponseSpecification responseSpec;
	
	@BeforeClass
	public void setUp() {
		requestBuilder =new RequestSpecBuilder();
		requestBuilder.setBaseUri("https://weather.visualcrossing.com");
		requestBuilder.setBasePath("/VisualCrossingWebServices/rest/services");
		requestBuilder.addQueryParam("key", "T4TTPGCG3AD5Q2LME8PNJATRY");
		requestSpec = requestBuilder.build();
		
		responseBuilder= new ResponseSpecBuilder();
		responseBuilder.expectStatusCode(200);
		responseBuilder.expectResponseTime(lessThan(9L), TimeUnit.SECONDS);
		responseSpec = responseBuilder.build();
	}
	
	@Test
	public void statusCodeVerification() {
		given()
			.spec(requestSpec)
	   .when()
			.get("/timeline/Pune")
		.then()
			.spec(responseSpec)
			.log().body()
			.body("address",equalTo("Pune"))
			.body("timezone",equalTo("Asia/Kolkata"));
	}

}
