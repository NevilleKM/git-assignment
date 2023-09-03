package com.assignment.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class APITest {

    private String apiKey;

    @BeforeClass
    public void setUp() {
        
        apiKey = "T4TTPGCG3AD5Q2LME8PNJATRY";
        RestAssured.baseURI = "https://weather.visualcrossing.com";
    }

    @Test
    public void testWeatherDataForCity() {
        String city = "Pune"; // 

        Response response = RestAssured.given()
                .queryParam("unitGroup", "metric")
                .queryParam("key", apiKey)
                .queryParam("contentType", "json")
                .when()
                .get("/VisualCrossingWebServices/rest/services/timeline/" + city);

        // Verify the response status code is 200 OK
        response.then().statusCode(200);

        // Verify that the response contains the correct city name
        response.then().body("address", equalTo(city));

        // Print the response for debugging
        response.body().prettyPrint();
    }
}
