package com.flight.app;

import com.flight.app.model.FlightAppRegistrationData;
import com.flight.app.model.SearchFlightData;
import commonClasses.JsonUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Parameters;

public class AbstractTestPage {
	
	protected WebDriver driver;
	protected FlightAppRegistrationData flightAppRegistrationData;
	protected SearchFlightData searchFlightData;
	@BeforeTest
	@Parameters({"RegistrationPath","searchFlightPath"})
	public void setDriver(String RegistrationPath, String searchFlightPath) {
		this.searchFlightData = JsonUtil.getTestData(searchFlightPath,SearchFlightData.class);
		this.flightAppRegistrationData = JsonUtil.getTestData(RegistrationPath,FlightAppRegistrationData.class);
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void quitDriver() {
		this.driver.quit();
	}
}
