package org.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.models.User;
import java.util.List;
import java.util.stream.Collectors;

public class DynamicTablePage {
    private  WebDriver driver;

    @FindBy(xpath = "//div[@id='tablehere']/following-sibling::details/summary")
    private WebElement tableDataButton;

    @FindBy(xpath = "//textarea[@id='jsondata']")
    private WebElement inputDataBox;

    @FindBy(xpath = "//button[text()='Refresh Table']")
    private WebElement refreshTableButton;

    @FindBy(css = "#dynamictable tr")
    private List<WebElement> tableRows;


    public DynamicTablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void clickTableDataButton() {
        tableDataButton.click();
    }

    public void enterData(String jsonData) {
        inputDataBox.clear();
        inputDataBox.sendKeys(jsonData);
    }

    public void clickRefreshTableButton() {
        refreshTableButton.click();
    }

    public void validateTableData(List<User> expectedUsers) {
        // Skip the header row and get the remaining rows (data rows)
        List<WebElement> dataRows = tableRows.stream().skip(1).collect(Collectors.toList());

        for (int i = 0; i < expectedUsers.size(); i++) {
            User expectedUser = expectedUsers.get(i);
            WebElement row = dataRows.get(i);

            // Get all cells in the current row
            List<WebElement> cells = row.findElements(By.tagName("td"));

            // Extract values from the row cells
            String name = cells.get(0).getText();
            String age = cells.get(1).getText();
            String gender = cells.get(2).getText();

            // Assert that each cell matches the expected user data
            assert name.equals(expectedUser.getName()) : "Name mismatch: expected " + expectedUser.getName() + " but got " + name;
            assert age.equals(String.valueOf(expectedUser.getAge())) : "Age mismatch: expected " + expectedUser.getAge() + " but got " + age;
            assert gender.equals(expectedUser.getGender()) : "Gender mismatch: expected " + expectedUser.getGender() + " but got " + gender;

        }
    }


}
