package StepDefinitions;

import Reports.Reports;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Hooks {
    public static int firstEjecucion = 0;
    public static WebDriver driver;
    @Before
    public void setUp(Scenario scenario) throws IOException {
        System.setProperty("webdriver.chrome.driver","/home/javier/Descargas/driver/chromedriver_linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("disable-notifications");
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver=new ChromeDriver(options);
        if (firstEjecucion == 0){
            Reports.initReport();
            firstEjecucion = 1;
        }
        Reports.startReport(scenario.getName());
    }
    @After
    public void finis(){driver.quit();
        Reports.finishReport();
    }

    public static WebDriver getDriver(){

        return driver;
    }
}

