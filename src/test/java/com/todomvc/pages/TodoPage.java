package com.todomvc.pages;

import com.todomvc.utils.TestManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TodoPage extends BasePage{

private Properties properties;

    public TodoPage() {
        super(BasePage.getDriver());
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/TestEnv/testenv.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void launchURL(){
        getDriver().get(properties.getProperty("env.baseurl"));
    }
}
