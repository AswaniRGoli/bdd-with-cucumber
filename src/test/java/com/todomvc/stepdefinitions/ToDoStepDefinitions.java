package com.todomvc.stepdefinitions;

import com.todomvc.pages.BasePage;
import com.todomvc.pages.TodoPage;
import com.todomvc.utils.TestManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ToDoStepDefinitions {

   private WebDriver driver;
   private TodoPage todoPage;

    public ToDoStepDefinitions(){
        this.driver = BasePage.getDriver();
        this.todoPage = new TodoPage();
    }

    @Given("the user login to the application")
    public void TheUserLoginToTheApplication(){
        todoPage.launchURL();
    }

    @And("Close the Browser")
    public void CloseTheBrowser(){
        BasePage.quitDriver();
    }

}
