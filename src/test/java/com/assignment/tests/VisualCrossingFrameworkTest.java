package com.assignment.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.assignment.properties.EndPoints;
import com.assignment.properties.Path;
import com.assignment.utilities.RestUtilities;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class VisualCrossingFrameworkTest {
	
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	
	@BeforeClass
	public void setUp() {
		// 3ways to set request specification
		reqSpec = RestUtilities.getRequestSpecification();
		reqSpec.basePath(Path.BASE_PATH_TIMELINE);
		//reqSpec.queryParam("unitGroup", "metric");  // can add query parameter here also
		reqSpec.queryParam("key", "T4TTPGCG3AD5Q2LME8PNJATRY");
		//RestUtilities.createQueryParam(reqSpec, "key", "T4TTPGCG3AD5Q2LME8PNJATRY"); //4th way using createOueryParam
		resSpec = RestUtilities.getResponseSpecification();
	}
	
	@Test
	public void readCity() {
		given()
		.spec(reqSpec)
		.spec(RestUtilities.createQueryParam(reqSpec, "unitGroup", "metric"))
   .when()
		.get(EndPoints.READ)
	.then()
		.spec(resSpec)
		.log().body()
		.body("address",equalTo("Pune"))
		.body("timezone",equalTo("Asia/Kolkata"));
	}

}
