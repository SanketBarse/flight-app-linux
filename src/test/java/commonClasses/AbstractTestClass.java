package commonClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;


import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

@Listeners({ListenerClass.class})
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
    public void setDriver(ITestContext ctx){

        if(Config.getProp("selenium_grid_enable").equalsIgnoreCase("true")){
            this.driver = getRemoteWebDriver();
        }else {
            this.driver =  getWebdriver();
        }
        ctx.setAttribute("driver" , this.driver);
    }

    public WebDriver getRemoteWebDriver(){
        capabilities = new ChromeOptions();
        if(Config.getProp("browser").equalsIgnoreCase("firefox")){
            capabilities = new FirefoxOptions();
        }
        try {
            String url = Config.getProp("hubUrl");
            String hubHost = Config.getProp("selenium_grid_hub_host");
            String FinalUrl = String.format(url,hubHost);

            this.driver = new RemoteWebDriver(new URL(FinalUrl), capabilities);
        }catch (Exception e){
            e.printStackTrace();
        }
        this.driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getWebdriver(){
        if(Config.getProp("browser").equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            this.driver = new FirefoxDriver();
        }else {
            WebDriverManager.chromedriver().setup();
            this.driver= new ChromeDriver();
        }
        this.driver.manage().window().maximize();
        return driver;
    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }
}
