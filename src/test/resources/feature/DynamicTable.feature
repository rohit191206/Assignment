Feature: Dynamic Table Data Input


  Scenario: Input data and verify table content using DataMap
    Given I navigate to the dynamic table page
    When I input the following user data and refresh the table
      | name     | age | gender |
      | Bob      | 20  | male   |
      | George   | 42  | male   |
      | Sara     | 42  | female |
      | Conor    | 40  | male   |
      | Jennifer | 42  | female |
    Then The table should display the correct data