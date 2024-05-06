package commonClasses;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener {

    public void onTestFailure(ITestResult result){
        TakesScreenshot driver = (TakesScreenshot) result.getTestContext().getAttribute("driver");
        String screenshot = driver.getScreenshotAs(OutputType.BASE64);
        String htmlImageFormat =   "<img width=700px src='data:image/png;base64,%s'/>";
        String htmlImage = String.format(htmlImageFormat,screenshot);
    }

}
