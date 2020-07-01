package Utility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.IOException;

public class FailureTestCaseScreenShot {
    WebDriver driver;

   public void tearDown(ITestResult result) throws IOException {
       if(ITestResult.FAILURE==result.getStatus())
           ScreenShot.Capture(driver, result.getName());
   }
}
