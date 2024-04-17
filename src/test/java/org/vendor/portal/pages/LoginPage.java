package org.vendor.portal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.vendor.portal.AbstractClass;

public class LoginPage extends AbstractClass{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[contains(@for,'customCheck')]")
    private WebElement checkBoxInput;

    @FindBy(id = "login")
    private WebElement loginInput;

    @override
    public boolean isAt(){
        wait.until(ExpectedConditions.visibilityOf(userNameInput));
        return userNameInput.isDisplayed();
    }

    public void setPassword(){
        userNameInput.sendKeys("");
    }
    public void setUserName(){
        passwordInput.sendKeys("");
    }

    public void setCheckBox(){
        passwordInput.click();
    }

    public void clickLoginBtn(){
        loginInput.click();
    }


}
