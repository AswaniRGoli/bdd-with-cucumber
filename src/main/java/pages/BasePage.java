package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class BasePage {
    private static WebDriver driver;


    private BasePage(){
    }

    public static WebDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            //  if (browser.equalsIgnoreCase("safari")) {
           // driver = new SafariDriver();

            // Desired capabilities for Chrome
           // SafariOptions options = new SafariOptions();


            // Initialize Remote WebDriver
            // WebDriver driver = new RemoteWebDriver(gridUrl, capabilities);
               ChromeOptions options = new ChromeOptions();
            //    options.addArguments("--start-maximized");

             driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            // }
        }
//        else {
//            throw new IllegalArgumentException("Unsupported browser: " + browser);
//        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
