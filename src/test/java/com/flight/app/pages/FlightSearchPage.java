package com.flight.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.flight.app.AbstractPage;

public class FlightSearchPage extends AbstractPage{
	
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
	
	public void selectPassenger() {
		Select select = new Select(passenger);
		select.selectByValue("2");
	}
	
	public void selectdepartFrom() {
		Select select = new Select(departFrom);
		select.selectByValue("London");
	}
	
	public void selectarrivedIn() {
		Select select = new Select(arrivedIn);
		select.selectByValue("Paris");
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
