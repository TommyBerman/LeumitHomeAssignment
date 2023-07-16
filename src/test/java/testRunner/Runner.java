package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import stepDefinition.Steps;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;




@RunWith(Cucumber.class)
@CucumberOptions(features = { "Feature" }, glue = { "stepDefinition" }, tags = { "@Leumit-table-assignment" }, plugin = { "pretty",
        "html:target/Cucumber-htmlreport", "json:target/cucumber-report.json",
        "com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport.html" }, monochrome = true)



public class Runner {


    static Properties prop = new Properties();
//    public static WebDriver driver;



    @BeforeClass



    public static void init() throws Throwable {



        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream input = loader.getResourceAsStream("config/Configuration.properties");
        try {
            prop.load(input);
        } catch (IOException e1) {
            input.close();
            e1.printStackTrace();
        }




        String Chrome_Driver = prop.getProperty("Chrome_Driver");

        System.setProperty("webdriver.chrome.driver", Chrome_Driver);

        ChromeOptions options = new ChromeOptions();
        options.addArguments( "--headless","--window-size=1920,1200","--ignore-certificate-errors");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        driver.manage().window().maximize();
        input.close();
        Steps.driver = driver;



    }



    @AfterClass



    public static void after() {



        Steps.driver.quit();



    }
}