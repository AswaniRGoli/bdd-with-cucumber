# BDD using Cucumber-Java-Selenium
## Clone
To clone repo, follow below:
``` 
git clone https://github.com/AswaniRGoli/bdd-with-cucumber.git
```
## Test
Follow below steps to execute tests:

> Pre-requisite: **OpenJDK 17** + **Maven** installed and ENV variables set.

- Using Maven
```
cd bdd-with-cucumber
mvn test
```
- Using Runner class `CucumberRunnerTest.java`. Update tags in runner class to execute a specific test case
```Java
@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/features"},
        glue={"com.todomvc.stepdefinitions"},
        tags={""},
        monochrome = true,
        plugin = {"pretty","html:target/cucumber-html-reports", "json:target/cucumber-html-reports/cucumber.json"}
)
public class CucumberRunnerTest {
}
```


