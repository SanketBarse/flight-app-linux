package com.flight.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTestPage {
	
	protected WebDriver driver;
	
	@BeforeTest
	public void setDriver() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void quitDriver() {
		this.driver.quit();
	}
}
