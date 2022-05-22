package com.todomvc.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/features"},
        glue={"com.todomvc.stepdefinitions"},
        // tags={""},
        monochrome = true,
        plugin = {"pretty","html:target/cucumber-html-reports", "json:target/cucumber-html-reports/cucumber.json"}
)
public class CucumberRunnerTest {
}
