package stepDefinition;

import com.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Steps {

    public static WebDriver driver; // = new ChromeDriver();
    public static String originalWindow = null;
    public static WebElement pricingCardSection = null;
    public static WebElement gridContainer = null;
    public static List<WebElement> gridItems = null;
    public static WebElement selectedGridItemView = null;
    public static WebElement selectedGridItemSelect = null;
    public static String selectedGridItemTitle = null;
    public static WebElement selectedServiceBanner = null;
    public static WebElement selectedServiceBannerDescription = null;
    public static String selectedServiceBody = null;
    private TablePage tablePage;
    private String searchValue;

    static Properties prop = new Properties();

    private String currentValue;

    public WebElement w3Table;
    public String searchColumnName;
    public String returnColumnName;

    public int searchColumnIndex;
    public int returnColumnIndex;
    public String[] companyArray;
    public String[] contactArray;
    public String[] countryArray;

    public String expectedText;

    public int xpathRowIndex;
    public int xpathColumnIndex;


    public Steps() {

        tablePage = new TablePage(driver);
    }

    @Given("^I go to the table website and get table$")
    public void I_go_to_the_table_website() throws Throwable {

        String siteUrl = "https://www.w3schools.com/html/html_tables.asp";

        driver.get(siteUrl);

        Thread.sleep(2000);

        w3Table = driver.findElement(By.id("customers"));

        if (w3Table != null) {
            try {
                assert true;
                Reporter.addStepLog("Success you have managed to bring the table element!");
                System.out.println("Success you have managed to bring the table element!");

            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        } else {
            try {
                assert false : "Failure the table element has not been found!";
                System.out.println("Failure the table element has not been found!");

            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }

    }

    @Then("I load data from config by choosing column index \"(.*?)\" and row index \"(.*?)\"$")
    public void loadDataFromConfig(int i, int j) throws Throwable {

        companyArray = new String[] {"First_Company_Name", "Second_Company_Name", "Third_Company_Name", "Fourth_Company_Name", "Fifth_Company_Name", "Sixth_Company_Name"};
        contactArray = new String[] {"First_Contact_Name", "Second_Contact_Name", "Third_Contact_Name", "Fourth_Contact_Name", "Fifth_Contact_Name", "Sixth_Contact_Name"};
        countryArray = new String[] {"First_Country_Name", "Second_Country_Name", "Third_Country_Name", "Fourth_Country_Name", "Fifth_Country_Name", "Sixth_Country_Name"};

        String[][] allArrays = {companyArray, contactArray, countryArray};

         ClassLoader loader = Thread.currentThread().getContextClassLoader();
         InputStream input = loader.getResourceAsStream("config/Configuration.properties");
         prop.load(input);

         searchValue = prop.getProperty(allArrays[i][j]);

         input.close();

        if (searchValue != null) {
            try {
                assert true;
                Reporter.addStepLog("Success, Name Chosen is: " + searchValue);
                System.out.println("Success, Name Chosen is: " + searchValue);

            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        } else {
            try {
                assert false : "Failure, the data  has not been found!";
                System.out.println("Failure, the data has not been found!");

            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }


    }




    @When("I choose search value in column \"(.*?)\" and return value in column \"(.*?)\"$")
    public void EnterSearchParameters(String value, String value2) throws Throwable{
        switch (value) {
            case "0":
                searchColumnName = "Company";
                searchColumnIndex = Integer.parseInt(value);
                break;
            case "1":
                searchColumnName = "Contact";
                searchColumnIndex = Integer.parseInt(value);
                break;
            case "2":
                searchColumnName = "Country";
                searchColumnIndex = Integer.parseInt(value);
                break;
            case "Company":
                searchColumnName = value;
                searchColumnIndex = 0;
                break;
            case "Contact":
                searchColumnName = value;
                searchColumnIndex = 1;
                break;
            case "Country":
                searchColumnName = value;
                searchColumnIndex = 2;
        }

        switch (value2) {
            case "0":
                returnColumnName = "Company";
                returnColumnIndex = Integer.parseInt(value2);
                break;
            case "1":
                returnColumnName = "Contact";
                returnColumnIndex = Integer.parseInt(value2);
                break;
            case "2":
                returnColumnName = "Country";
                returnColumnIndex = Integer.parseInt(value2);
                break;
            case "Company":
                returnColumnName = value2;
                returnColumnIndex = 0;
                break;
            case "Contact":
                returnColumnName = value2;
                returnColumnIndex = 1;
                break;
            case "Country":
                returnColumnName = value2;
                returnColumnIndex = 2;
        }
        getValue();

        if (value.equals("") || value2.equals("")) {
            try {
                assert false : "Failure, search values cannot be empty!";
                System.out.println("Failure, search values cannot be empty!");

            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }
    }

    @Then("^I verify the cell text with my text \"(.*?)\"$")
    public void VerifyTextWithOwnText(String myText) throws Throwable {
        expectedText = myText;
        assertValue();

        if (myText.equals("")) {
            try {
                assert false : "Failure, search values cannot be empty!";
                System.out.println("Failure, search values cannot be empty!");

            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }

    }


    @Then("I choose by xpath in row \"(.*?)\" and in column \"(.*?)\"$")
    public void EnterXPathParameters(int row, int column) throws Throwable{
        xpathRowIndex = row;
        xpathColumnIndex = column;
        getValueByXPath();
    }



    public void getValue() throws Throwable{

        tablePage.getTableCellText(w3Table, searchColumnName, searchColumnIndex, searchValue, returnColumnName, returnColumnIndex);

    }

    public void getValueByXPath() throws Throwable {
        tablePage.getTableCellTextByXPath(w3Table, xpathRowIndex, xpathColumnIndex );
    }

    public void assertValue() throws Throwable {
        tablePage.VerifyTableText(expectedText);
    }



}
