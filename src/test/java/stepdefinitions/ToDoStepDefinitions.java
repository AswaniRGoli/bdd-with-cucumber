package stepdefinitions;

import pages.BasePage;
import pages.TodoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class ToDoStepDefinitions {

   private WebDriver driver;
   private TodoPage todoPage;

    public ToDoStepDefinitions() throws MalformedURLException {
        this.driver = BasePage.getDriver();
        this.todoPage = new TodoPage();
    }

    @Given("the user login to the application")
    public void TheUserLoginToTheApplication() throws MalformedURLException {
        todoPage.launchURL();
    }

    @And("Close the Browser")
    public void CloseTheBrowser(){
        BasePage.quitDriver();
    }

}
