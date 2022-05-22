package com.todomvc.stepdefinitions;

import com.todomvc.pages.TodoPage;
import com.todomvc.utils.TestManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.InvalidArgumentException;

import java.util.List;

public class ToDoStepDefinitions {
    private final TodoPage todoPage;

    public ToDoStepDefinitions(TestManager testManager) {
        this.todoPage = new TodoPage(testManager);
    }

    @Given("the user opened the TODO page")
    public void theUserOpenedTheTODOPage() {
        todoPage.launchPage();
    }

    @When("user created the following TODO items")
    public void userCreatedTheFollowingTODOItems(List<String> todoItems) {
        for (String item : todoItems) {
            todoPage.enterNewToDo(item);
        }
    }

    @Then("the following items are displayed in TODO list")
    @Then("All the completed and TODO items are displayed")
    public void theFollowingItemsAreDisplayedInTODOList(List<String> expectedItemsList) {
        List<String> actualItemsList = todoPage.getListOfItems();
        for (int i = 0; i < expectedItemsList.size(); i++) {
            String expectedItem = expectedItemsList.get(i);
            String actualItem = actualItemsList.get(i);
            Assert.assertTrue("The todo items are matching", expectedItem.equalsIgnoreCase(actualItem));
        }
    }

    @When("user completes the following TODO items")
    public void userCompletesTheFollowingTODOItems(List<String> expectedItemsList) {
        for (String s : expectedItemsList) {
            todoPage.selectToDoItem(s);
        }
    }

    @Then("the following items are marked as completed")
    @Then("All completed items are displayed")
    public void theFollowingItemsAreMarkedAsCompleted(List<String> expectedItemsList) {
        for (String expectedItem : expectedItemsList) {
            String completedItem = todoPage.getToDoCompletedItem(expectedItem);
            Assert.assertTrue("The todo items are matching", expectedItem.equalsIgnoreCase(completedItem));
        }
    }

    @And("the following items are shown as to do")
    @Then("All active TODO items are displayed")
    public void theFollowingItemsAreShownAsToDo(List<String> expectedItemsList) {
        for (String expectedItem : expectedItemsList) {
            String toDoItem = todoPage.getToDoItem(expectedItem);
            Assert.assertTrue("The todo items are matching", expectedItem.equalsIgnoreCase(toDoItem));
        }
    }

    @And("the count of TODO items is shown as {string}")
    public void theCountOfTODOItemsIsShownAs(String countofItemsLeft) {
        int countOfToDoItems = todoPage.getCountOfToDoItems();
        int countOfItemsLeft = todoPage.getCountOfItemsLeft();
        Assert.assertTrue("the items left count doesn't match with expected count", countOfToDoItems == countOfItemsLeft && countofItemsLeft.equalsIgnoreCase(todoPage.getTextCountOfItemsLeft()));
    }

    @And("User deletes the following {string} items")
    public void userDeletesTheFollowingCompletedItems(String itemName, List<String> deleteItemsList) {
        for (String s : deleteItemsList) {
            switch (itemName) {
                case "TODO" -> todoPage.deleteToDoItems(s);
                case "Completed" -> todoPage.deleteCompletedItems(s);
                case "All" -> todoPage.deleteAllItems(s);
                default -> throw new InvalidArgumentException("Invalid item passed : " + itemName);
            }
        }
    }

    @Then("the following {string} items are deleted")
    public void theFollowingCompletedItemsAreDeleted(String itemName, List<String> deleteItemsList) throws Exception {
        for (String s : deleteItemsList) {
            switch (itemName) {
                case "TODO" -> Assert.assertTrue(todoPage.isToDoItemDeleted(s));
                case "Completed" -> Assert.assertTrue(todoPage.isCompletedItemDeleted(s));
                case "All" -> Assert.assertTrue(todoPage.areAllItemsDeleted(s));
                default -> throw new InvalidArgumentException("Invalid item passed : " + itemName);
            }
        }

    }

    @When("user selects option {string}")
    public void userSelectsOption(String selectItemToFilter) {
            todoPage.selectFooterLinkToFilterItems(selectItemToFilter);
    }

    @When("User modifies the following {string} item to {string}")
    public void userModifiesTheFollowingItemTo(String item, String modifiedItem, List<String> listOfItems) {
        for (String listOfItem : listOfItems) {
            switch (item) {
                case "TODO" -> todoPage.editToDoItem(listOfItem, modifiedItem);
                case "Completed" -> todoPage.editCompletedItem(listOfItem, modifiedItem);
                default -> throw new InvalidArgumentException("Invalid item passed : " + item);
            }
        }
    }

    @Then("the {string} item is modified to {string} in TODO list")
    public void theItemIsModifiedToInTODOList(String itemList, String modifiedItem) {
        switch (itemList) {
            case "TODO" -> Assert.assertTrue(modifiedItem.equalsIgnoreCase(todoPage.getToDoItem(modifiedItem)));
            case "Completed" ->
                    Assert.assertTrue(modifiedItem.equalsIgnoreCase(todoPage.getToDoCompletedItem(modifiedItem)));
            default -> throw new InvalidArgumentException("Invalid item passed : " + itemList);
        }
    }
}
