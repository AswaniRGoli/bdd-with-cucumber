package com.todomvc.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestManager {
    private static WebDriver driver;

    private final Properties properties;

    public TestManager() {
        this.properties =  new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/TestEnv/testenv.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver(chromeOptions);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void resetDriver(){
        driver = null;
    }

    public Properties getProperties() {
        return properties;
    }
}
