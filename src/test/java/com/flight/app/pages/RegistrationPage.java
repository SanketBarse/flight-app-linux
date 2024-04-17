package com.flight.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.flight.app.AbstractPage;

public class RegistrationPage extends AbstractPage{
	
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "firstName")
	private WebElement firstName;
	
	@FindBy(id = "lastName")
	private WebElement lastName;
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(xpath = "//input[contains(@name,'street')]")
	private WebElement street;
	
	@FindBy(xpath = "//input[contains(@name,'city')]")
	private WebElement city;
	
	@FindBy(id = "register-btn")
	private WebElement registerButton;
	
	public void firstNameInput(String fName) {
		firstName.sendKeys(fName);
	}
	
	public void lastNameInput(String lName) {
		lastName.sendKeys(lName);
	}
	
	public void emailInput(String emailInp) {
		email.sendKeys(emailInp);
	}
	
	public void passwordInput(String passwordInp) {
		email.sendKeys(passwordInp);
	}
	
	public void streetInput(String streetInp) {
		email.sendKeys(streetInp);
	}
	
	public void cityInput(String cityInp) {
		email.sendKeys(cityInp);
	}
	
	public void clickRegisterButton() {
		registerButton.click();
	}
	
	
	public void goTo(String url) {
		driver.get(url);
	}
	
	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(firstName));
		return this.firstName.isDisplayed();
	}
	
}
