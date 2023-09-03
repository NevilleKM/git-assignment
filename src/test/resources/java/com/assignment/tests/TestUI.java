package com.assignment.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.assigment.base.BaseTest;
import com.assignment.pages.VisualCrossingPage;


public class TestUI extends BaseTest {
	
	WebDriver driver;
	Logger log = Logger.getLogger(TestUI.class);
	VisualCrossingPage visualPage;
	Properties prop = new Properties();

    @BeforeClass
    public void setUp() throws IOException {
        
        // Open VisualCrossing.com
    	FileInputStream input = new FileInputStream("C:\\Properties\\application.properties");
    	prop.load(input);
    	getdriver().get(prop.getProperty("url"));
    	visualPage= new VisualCrossingPage(getdriver());
    	
    	//Click on accept cookies
    	visualPage.acceptAllCookies();
    }

    @Test
    public void testWeatherForecast() throws InterruptedException {
    	
    	//Click on weather data
    	visualPage.weatherData();
    	
        // Input city name
    	visualPage.enterCity("Pune");
        
        // Click on search button
    	visualPage.search();
        
        // Verify max temp
    	Thread.sleep(2000);
        if(visualPage.maxTempLabel().contains("℃")) {
        	log.info("Maximum temperature is displayed");
        }
        
        // Verify min temp
        if(visualPage.minTempLabel().contains("℃")) {
        	log.info("Minimum temperature is displayed");
        }
        
        
    }
    
    @Test
    public void testWeatherForecastinFarenheit() throws InterruptedException {
    	
        
    	//Click on weather data
    	visualPage.weatherData();
    	
        // Input city name
    	visualPage.enterCity("Pune");
        
        // Click on search button
    	visualPage.search();
    	
    	// Click on farenheit option
    	Thread.sleep(2000);
    	visualPage.farenheitOption();
        
        // Verify max temp
    	Thread.sleep(5000);
        if(visualPage.maxTempLabel().contains("℉")) {
        	log.info("Maximum temperature is displayed");
        }
        
        // Verify min temp
        if(visualPage.minTempLabel().contains("℉")) {
        	log.info("Minimum temperature is displayed");
        }
        
        
    }

    @AfterClass
    public void tearDown() {
        if (getdriver() != null) {
        	getdriver().quit();
        }
    }
}
