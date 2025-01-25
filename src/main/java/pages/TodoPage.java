package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class TodoPage extends BasePage{

private Properties properties;

    public TodoPage() throws MalformedURLException {
        super(BasePage.getDriver());
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/TestEnv/testenv.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void launchURL() throws MalformedURLException {
        getDriver().get(properties.getProperty("env.baseurl"));
        // URL of the Selenium Grid Hub
        //URL gridUrl = new URL("http://localhost:4444");




    }
}
