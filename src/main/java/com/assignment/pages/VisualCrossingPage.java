package com.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assigment.base.BaseTest;

public class VisualCrossingPage extends BaseTest {
	
	WebDriver driver;
	
	public VisualCrossingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Weather Data']")
	public WebElement weatherData;
	
	@FindBy(xpath="//button[text()='Accept all cookies']")
	public WebElement acceptCookies;
	
	@FindBy(xpath="//input[@id='wxlocation']")
	public WebElement setCity;
	
	@FindBy(xpath="//button[text()='Search']")
	public WebElement Search;
	
	@FindBy(xpath="//button[text()='F']")
	public WebElement farenheit;
	
	@FindBy(xpath="//div[text()='Max temp']/following-sibling::div")
	public WebElement maxTemp;
	
	@FindBy(xpath="//div[text()='Min temp']/following-sibling::div")
	public WebElement minTemp;
	
	public void acceptAllCookies()
	{
    	acceptCookies.click();
	}
	
	public void weatherData()
	{
		weatherData.click();
	}
	
	public void enterCity(String city)
	{
		setCity.sendKeys(city);;
	}
	
	public void search()
	{
    	Search.click();
	}
	
	public void farenheitOption()
	{
		farenheit.click();
	}
	
	public String maxTempLabel()
	{
		return maxTemp.getText();
	}
	
	public String minTempLabel()
	{
		return minTemp.getText();
	}
	

}
