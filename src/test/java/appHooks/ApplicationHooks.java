package appHooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.ConfigReader;

import java.util.Properties;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties properties;

    @Before(order = 0)
    public void getProperty(){
        configReader = new ConfigReader();
        configReader.init_prop();
        properties = configReader.init_prop();
    }

    @Before (order = 1)
    public void setDriver(){
        String browserName = properties.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
    }

    @After (order = 0)
    public void quitDriver(){
        driver.quit();
     }

     @After (order = 1)
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            //Take a screenshot
           String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath,"image/png",screenshotName);

        }
     }




}
