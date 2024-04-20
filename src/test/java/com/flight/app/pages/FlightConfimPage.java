package com.flight.app.pages;

import commonClasses.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FlightConfimPage extends AbstractPage {

	public FlightConfimPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "#flights-confirmation-section .row:nth-child(1) .col:nth-child(2)")
	private WebElement  flightConfimationElement;
		

	@FindBy(css = "#flights-confirmation-section .row:nth-child(3) .col:nth-child(2)")
	private WebElement  flightPrice;
	
	
	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(flightConfimationElement));
		return flightConfimationElement.isDisplayed();
	}
	
	public String getPrice() {
		return this.flightPrice.getText();
	}
	
	
}
