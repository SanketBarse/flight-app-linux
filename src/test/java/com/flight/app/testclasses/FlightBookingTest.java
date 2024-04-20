package com.flight.app.testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.flight.app.AbstractTestPage;
import com.flight.app.pages.FlightConfimPage;
import com.flight.app.pages.FlightSearchPage;
import com.flight.app.pages.RegistrationConfirmationPage;
import com.flight.app.pages.RegistrationPage;
import com.flight.app.pages.SelectFlightPage;


public class FlightBookingTest extends AbstractTestPage{

	
	@Test
	public void registration(){
		
		RegistrationPage rp = new RegistrationPage(driver);
		rp.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
		Assert.assertTrue(rp.isAt());
		
		rp.firstNameInput(flightAppRegistrationData.firstName());
		rp.lastNameInput(flightAppRegistrationData.lastName());
		rp.emailInput(flightAppRegistrationData.email());
		rp.streetInput(flightAppRegistrationData.street());
		rp.cityInput(flightAppRegistrationData.city());
		rp.clickRegisterButton();
		
	}
	
	@Test(dependsOnMethods = "registration")
	public void registrationConfirmation() { 
		RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
		Assert.assertTrue(registrationConfirmationPage.isAt()); 
		registrationConfirmationPage.clickSeachButton();
	}
	
	@Test(dependsOnMethods = "registrationConfirmation")
	public void flightSearch() {
		FlightSearchPage flightSearchPage = new FlightSearchPage(driver);
		flightSearchPage.isAt();
		flightSearchPage.selectPassenger(searchFlightData.noOfPassenger());
		flightSearchPage.selectDepartFrom(searchFlightData.departFrom());
		flightSearchPage.selectArrivedIn(searchFlightData.arrivedIn());
		flightSearchPage.clickSearchButton();
	}
	
	@Test(dependsOnMethods = "flightSearch")
	public void selectFlight() {
		SelectFlightPage selectFlightPage = new SelectFlightPage(driver);
		selectFlightPage.isAt();
		selectFlightPage.selectFlight();
		selectFlightPage.clickConfirmFlight();
		 
	}
	
	@Test(dependsOnMethods = "selectFlight")
	public void confirmFlight(){
		FlightConfimPage flightConfirmPage = new FlightConfimPage(driver);
		flightConfirmPage.isAt();
		flightConfirmPage.getPrice();
	}
	
}
