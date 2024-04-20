package org.vendor.portal;

import commonClasses.JsonUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.vendor.portal.model.VendorPortalTestData;

public class AbstractTestClass {

    protected WebDriver driver;
    protected VendorPortalTestData testData;

    @BeforeTest
    @Parameters("testDataPath")
    public void setDriver(String testDataPath){
        this.testData = JsonUtil.getTestData(testDataPath,VendorPortalTestData.class);
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void quitDriver(){
        driver.quit();
    }

}
