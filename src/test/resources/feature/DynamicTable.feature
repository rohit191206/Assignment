Feature: Dynamic Table Data Input


  Scenario: Input data and verify table content using DataMap
    Given I navigate to the dynamic table page
    When I input the following user data and refresh the table
    Then The table should display the correct data