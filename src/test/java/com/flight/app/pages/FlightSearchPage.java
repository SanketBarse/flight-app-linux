package com.flight.app.pages;

import commonClasses.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage extends AbstractPage {
	
	public FlightSearchPage(WebDriver driver) {
		super(driver);
	}
		
	@FindBy(id = "passengers")
	private WebElement passenger;
	
	@FindBy(id = "depart-from")
	private WebElement departFrom;
	
	@FindBy(id = "arrive-in")
	private WebElement arrivedIn;
	
	@FindBy(id = "search-flights")
	private WebElement searchFlightButton;
	
	public void selectPassenger(String noOfPassenger) {
		Select select = new Select(passenger);
		select.selectByValue(noOfPassenger);
	}
	
	public void selectDepartFrom(String depart) {
		Select select = new Select(departFrom);
		select.selectByValue(depart);
	}
	
	public void selectArrivedIn(String arrived) {
		Select select = new Select(arrivedIn);
		select.selectByValue(arrived);
	}
	
	public void clickSearchButton() {
		searchFlightButton.click();
	}
	
	@Override
	public boolean isAt() {
		wait.until(ExpectedConditions.visibilityOf(arrivedIn));
		return arrivedIn.isDisplayed();
	}
}
