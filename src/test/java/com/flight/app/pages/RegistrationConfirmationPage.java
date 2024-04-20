package com.flight.app.pages;


import commonClasses.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class RegistrationConfirmationPage extends AbstractPage {
	
	
	public RegistrationConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "go-to-flights-search")
	private WebElement flightSearchButton;
	
	public void clickSeachButton() {
		flightSearchButton.click();
	}
	
	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(flightSearchButton));
		return this.flightSearchButton.isDisplayed();
	}
}
