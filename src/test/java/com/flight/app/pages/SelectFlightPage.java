package com.flight.app.pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.flight.app.AbstractPage;

public class SelectFlightPage extends AbstractPage {

	public SelectFlightPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "departure-flight")
	private List<WebElement> departureFlightOptions;

	@FindBy(name = "arrival-flight")
	private List<WebElement> arrivalFlightOptions;

	@FindBy(id = "confirm-flights")
	private WebElement confimFlightButton;

	@Override
	public boolean isAt() {
		wait.until(ExpectedConditions.visibilityOf(departureFlightOptions.get(0)));
		return departureFlightOptions.get(0).isDisplayed();
	}

	public void selectFlight() {
		int random = ThreadLocalRandom.current().nextInt(0,departureFlightOptions.size());
		departureFlightOptions.get(random).click();
		arrivalFlightOptions.get(random).click();
	}

	public void clickConfirmFlight() {
		confimFlightButton.click();
	}

}
