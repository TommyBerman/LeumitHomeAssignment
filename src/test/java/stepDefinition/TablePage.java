package stepDefinition;

import com.cucumber.listener.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;

public class TablePage {


    private WebDriver driver;

    public String wantedValue;

    public boolean outcome;

    public TablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String getTableCellText(WebElement table, String searchColumnName,int searchColumnIndex, String searchText, String returnColumnName ,int returnColumnIndex) {
        // Find all rows in the table
        List<WebElement> rowElements = table.findElements(By.tagName("tr"));
        int rowSize = rowElements.size();
        // Find all headers in the table
        List<WebElement> headerElements = rowElements.get(0).findElements(By.tagName("th"));
        int headersSize = headerElements.size();


        //First we find the index of the requested search column
        List<WebElement> targetRowCells = null;
        if (searchColumnName != null) {
            for (int i = 0; i < headersSize; i++) {
                if (headerElements.get(i).getText().equals(searchColumnName)) {
                    searchColumnIndex = i;
                    break;
                }
            }


            //Then we find the index of the return column header
            if (returnColumnName != null) {
                for (int i = 0; i < headersSize; i++) {
                    if (headerElements.get(i).getText().equals(returnColumnName)) {

                        returnColumnIndex = i;
                        break;
                    }
                }
            }

            // Find the row with the desired search text
            WebElement targetRow = null;
            for (int i = 1; i < rowSize; i++) {
                List<WebElement> cells = rowElements.get(i).findElements(By.tagName("td"));
                if (cells.get(searchColumnIndex).getText().equals(searchText)) {
                    targetRow = rowElements.get(i);
                    break;
                }
            }

            if (targetRow == null) {
                throw new NoSuchElementException("Row with search text not found.");
            }

            // Get the text of the cell in the return column
            targetRowCells = targetRow.findElements(By.tagName("td"));
            wantedValue = targetRowCells.get(returnColumnIndex).getText();

        }

        if (!Objects.equals(wantedValue, "")) {
            try {
                assert true;
                outcome = true;
                Reporter.addStepLog("Success, Wanted value is: " + wantedValue);
                System.out.println("Success, Wanted value is: " + wantedValue);

            } catch (java.util.NoSuchElementException e) {
                e.printStackTrace();
            }
        } else {
            try {
                assert false;
                outcome = false;
                Reporter.addStepLog("Failure, wanted value is empty!");
                System.out.println("Failure, wanted value is empty!");

            } catch (java.util.NoSuchElementException e) {
                e.printStackTrace();
            }
        }

        return wantedValue;
    }

    public Boolean VerifyTableText(String expectedText) throws Throwable {

        if (Objects.equals(wantedValue, expectedText)) {
            try {
                assert true;
                outcome = true;
                Reporter.addStepLog("Success the value of getTableCellText and expectedText are the same!");
                System.out.println("Success the value of getTableCellText and expectedText are the same!");

            } catch (java.util.NoSuchElementException e) {
                e.printStackTrace();
            }
        } else {
            try {
                assert false;
                outcome = false;
                Reporter.addStepLog("Failure the value of getTableCellText and expectedText are not the same!");
                System.out.println("Failure the value of getTableCellText and expectedText are not the same!");

            } catch (java.util.NoSuchElementException e) {
                e.printStackTrace();
            }
        }
        return outcome;
    }



    public String getTableCellTextByXPath(WebElement table,int searchRowIndex ,int searchColumnIndex) {


        WebElement rowElement = table.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr["+searchRowIndex+"]/td["+searchColumnIndex+"]"));
        wantedValue = rowElement.getText();

        if (!Objects.equals(wantedValue, "")) {
            try {
                assert true;
                outcome = true;
                Reporter.addStepLog("Success, Wanted value is: " + wantedValue);
                System.out.println("Success, Wanted value is: " + wantedValue);

            } catch (java.util.NoSuchElementException e) {
                e.printStackTrace();
            }
        } else {
            try {
                assert false;
                outcome = false;
                Reporter.addStepLog("Failure, wanted value is empty!");
                System.out.println("Failure, wanted value is empty!");

            } catch (java.util.NoSuchElementException e) {
                e.printStackTrace();
            }
        }

        return wantedValue;
    }



}

