package commonClasses;

import com.flight.app.model.FlightAppRegistrationData;
import com.flight.app.model.SearchFlightData;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.vendor.portal.model.VendorPortalTestData;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class AbstractTestClass {

    protected WebDriver driver;


    private Properties prop;
    private File file;
    private FileInputStream inputStream;
    private String browser;
    private Capabilities capabilities;

    @BeforeSuite
    public void init(){
        Config.initialized();
    }

    @BeforeTest
    public void setDriver(){

        if(Config.getProp("selenium_grid_enable").equalsIgnoreCase("true")){
            getRemoteWebDriver();
        }else {
            getWebdriver();
        }
    }

    public void getRemoteWebDriver(){
        capabilities = new ChromeOptions();
        if(Config.getProp("browser").equalsIgnoreCase("firefox")){
            capabilities = new FirefoxOptions();
        }
        try {
            this.driver = new RemoteWebDriver(new URL(Config.getProp("hubUrl")), capabilities);
        }catch (Exception e){
            e.printStackTrace();
        }
        this.driver.manage().window().maximize();
    }

    public void getWebdriver(){
        if(Config.getProp("browser").equalsIgnoreCase("firefox")){
            this.driver = new FirefoxDriver();
        }else {
            this.driver= new ChromeDriver();
        }
        this.driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }
}
