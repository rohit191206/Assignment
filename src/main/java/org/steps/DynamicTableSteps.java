package org.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.base.BaseTest;
import org.models.User;
import org.openqa.selenium.WebDriver;
import org.page.DynamicTablePage;
import org.utils.DataHelper;
import org.utils.JsonHelper;

import java.util.List;

public class DynamicTableSteps extends BaseTest {

    private DynamicTablePage dynamicTablePage;
    private List<User> users;
    private String jsonData;



    @Given("I navigate to the dynamic table page")
    public void i_navigate_to_the_dynamic_table_page() {
        setUp();
        driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
        dynamicTablePage = new DynamicTablePage(driver);
    }

    @When("I input the following user data and refresh the table")
    public void i_input_the_following_user_data_and_refresh_the_table(DataTable dataTable) {
        users = DataHelper.mapToUserList(dataTable);
        jsonData = JsonHelper.convertToJson(users);
        dynamicTablePage.clickTableDataButton();
        dynamicTablePage.enterData(jsonData);
        dynamicTablePage.clickRefreshTableButton();
    }

    @Then("The table should display the correct data")
    public void the_table_should_display_the_correct_data() {
        dynamicTablePage.validateTableData(users);
        tearDown();
    }
}
