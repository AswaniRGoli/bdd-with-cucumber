package com.todomvc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    private static WebDriver driver;


    private BasePage(){
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            //  if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
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
