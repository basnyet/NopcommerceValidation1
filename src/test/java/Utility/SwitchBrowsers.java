package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SwitchBrowsers {

    WebDriver driver;

    public static WebDriver getbrowser() {
        WebDriver driver = null;
        switch (PathStore.BROWSER_NAME_C.toUpperCase()) {

            case "CHROME":
                System.setProperty("BROWSER_NAME_C",PathStore.CHROME_DRIVER_PATH);
                driver=new ChromeDriver();
                break;

            case "FIREFIX":
                System.setProperty("BROWSER_NAME_G",PathStore.GECKO_DRIVER_PATH);
                driver=new FirefoxDriver();
                break;

            case "INTERNETEXPLORER":
                System.setProperty("BROWSER_NAME_I", PathStore.IE_PATH);
                driver = new InternetExplorerDriver();
                break;

            default:
                new RuntimeException("Invalid browser name:"+PathStore.BROWSER_NAME_C);
                break;

        }

        return driver;
    }
}
