package com.todomvc.stepdefinitions;

import com.todomvc.utils.TestManager;
import io.cucumber.java.After;

public class Hooks {

    private final TestManager testManager;

    public Hooks(TestManager testManager){

        this.testManager = testManager;
    }

    @After()
    public void tearDown() {
        if(this.testManager.getDriver() != null) {
            this.testManager.getDriver().close();
            this.testManager.getDriver().quit();
            this.testManager.resetDriver();
        }
    }
}
