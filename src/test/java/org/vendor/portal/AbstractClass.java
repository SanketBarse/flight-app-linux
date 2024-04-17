package org.vendor.portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractClass {

    protected final WebDriver driver;
    protected  final WebDriverWait wait;

    public AbstractClass(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver , Duration.ofSeconds(30));
    }

    public abstract boolean isAt();

}
