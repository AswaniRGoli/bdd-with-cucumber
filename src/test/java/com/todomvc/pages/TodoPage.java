package com.todomvc.pages;

import com.todomvc.utils.TestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class TodoPage {

    private final TestManager testManager;

    public TodoPage(TestManager testManager) {
        this.testManager = testManager;
        actions = new Actions(this.testManager.getDriver());
        PageFactory.initElements(this.testManager.getDriver(), this);
    }

    @FindBy(xpath = "//input[@class='new-todo']")
    private WebElement textWhatNeedsToBeDone;

    @FindBy(xpath = "//a[@href='#/all']")
    private WebElement linkAll;

    @FindBy(xpath = "//a[@href='#/active']")
    private WebElement linkActive;

    @FindBy(xpath = "//a[@href='#/completed']")
    private WebElement linkCompleted;

    @FindBy(xpath = "//button[@class='clear-completed']")
    private WebElement buttonClearCompleted;

    @FindBy(xpath = "//footer/span[@class='todo-count']")
    private WebElement textItemsLeft;

    @FindBy(xpath = "//section/ul[@class='todo-list']/li/div/label")
    private List<WebElement> listOfItems;

    @FindBy(xpath = "//h1[text()='todos']")
    private WebElement headerTodos;

    @FindBy(xpath = "//span[@class='todo-count']/strong")
    private WebElement countOfToDoItemsLeft;

    @FindBy(xpath = "//li[@class='todo']/div/label")
    private List<WebElement> countOfToDoItems;

    private final Actions actions;

    public void launchPage() {
        String url = this.testManager.getProperties().getProperty("env.baseurl");
        this.testManager.getDriver().navigate().to(url);
    }

    public void enterNewToDo(String newToDo) {
        textWhatNeedsToBeDone.sendKeys(newToDo);
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    public void selectToDoItem(String newToDo) {
        this.testManager.getDriver().findElement(By.xpath("//div/label[text()='" + newToDo + "']/parent::div/input[@type='checkbox']")).click();
    }

    public List<String> getListOfItems() {
        List<String> list = new ArrayList<>();
        for (WebElement item : listOfItems) {
            list.add(item.getText());
        }
        return list;
    }

    public String getToDoCompletedItem(String itemName) {
        return this.testManager.getDriver().findElement(By.xpath("//li[@class='todo completed']/div/label[text()='" + itemName + "']")).getText();
    }

    public String getToDoItem(String itemName) {
        return this.testManager.getDriver().findElement(By.xpath("//li[@class='todo']/div/label[text()='" + itemName + "']")).getText();
    }

    public Boolean isToDoItemDeleted(String itemName) throws InterruptedException {
        Thread.sleep(2000);
        return this.testManager.getDriver().findElements(By.xpath("//li[@class='todo']/div/label[text()='" + itemName + "']")).size() == 0;
    }

    public int getCountOfToDoItems() {
        return countOfToDoItems.size();
    }

    public int getCountOfItemsLeft() {
        return Integer.parseInt(countOfToDoItemsLeft.getText());
    }

    public String getTextCountOfItemsLeft() {
        return textItemsLeft.getText();
    }

    public void deleteToDoItems(String deleteToDoItem) {
        actions.moveToElement(this.testManager.getDriver().findElement(By.xpath("//li[@class='todo']/div/label[text()='" + deleteToDoItem + "']")));
        this.testManager.getDriver().findElement(By.xpath("//li[@class='todo']/div/label[text()='" + deleteToDoItem + "']/following-sibling::button")).click();
    }

    public void deleteAllItems(String deleteToDoItem) {
        if (this.testManager.getDriver().findElement(By.xpath("//section/ul[@class='todo-list']/li/div/label[text()='" + deleteToDoItem + "']")).isDisplayed()) {
            actions.moveToElement(this.testManager.getDriver().findElement(By.xpath("//section/ul[@class='todo-list']/li/div/label[text()='" + deleteToDoItem + "']")));
            this.testManager.getDriver().findElement(By.xpath("//ul[@class='todo-list']/li/div/label[text()='" + deleteToDoItem + "']/following-sibling::button")).click();
        }
    }

    public Boolean areAllItemsDeleted(String deleteToDoItem) {
        return this.testManager.getDriver().findElements(By.xpath("//section/ul[@class='todo-list']/li/div/label[text()='" + deleteToDoItem + "']")).size() == 0;
    }

    public void deleteCompletedItems(String deleteToDoItem) {
        actions.moveToElement(this.testManager.getDriver().findElement(By.xpath("//li[@class='todo completed']/div/label[text()='" + deleteToDoItem + "']")));
        this.testManager.getDriver().findElement(By.xpath("//li[@class='todo completed']/div/label[text()='" + deleteToDoItem + "']/following-sibling::button")).click();
    }

    public Boolean isCompletedItemDeleted(String deleteToDoItem) {
        return this.testManager.getDriver().findElements(By.xpath("//li[@class='todo completed']/div/label[text()='" + deleteToDoItem + "']")).size() == 0;
    }

    public void editToDoItem(String actualItem, String ModifyItem) {

        actions.moveToElement(this.testManager.getDriver().findElement(By.xpath("//li[@class='todo']/div/label[text()='" + actualItem + "']")));
        actions.doubleClick();
        for(int i =0; i< actualItem.length(); i++){
            actions.sendKeys(Keys.BACK_SPACE);
        }

        actions.sendKeys(ModifyItem)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
    }

    public void editCompletedItem(String actualItem, String ModifyItem) {
        actions.moveToElement(this.testManager.getDriver().findElement(By.xpath("//li[@class='todo completed']/div/label[text()='" + actualItem + "']")));
        actions.doubleClick();
        for(int i =0; i< actualItem.length(); i++){
            actions.sendKeys(Keys.BACK_SPACE);
        }

        actions.sendKeys(ModifyItem)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
    }

    public void  selectFooterLinkToFilterItems(String linkType){
        switch (linkType) {
            case "All" -> linkAll.click();
            case "Active" -> linkActive.click();
            case "Completed" -> linkCompleted.click();
            case "Clear completed" -> buttonClearCompleted.click();
            default -> throw new InvalidArgumentException("Invalid link option passed");
        }
    }


}
