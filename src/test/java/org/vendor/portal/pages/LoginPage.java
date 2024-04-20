package org.vendor.portal.pages;

import commonClasses.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {

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


    public boolean isAt(){
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        return this.passwordInput.isDisplayed();
    }

    public void setPassword(String userName){
        userNameInput.sendKeys(userName);
    }
    public void setUserName(String password){
        passwordInput.sendKeys(password);
    }

    public void setCheckBox(){
        passwordInput.click();
    }

    public void clickLoginBtn(){
        loginInput.click();
    }

    public void goTo(String url){
        driver.get(url);
    }


}
