@Leumit-table-assignment

Feature: Assignment to get table content by search value or index

  Scenario: User go to table website and search for a value
    Given I go to the table website and get table

    Then I load data from config by choosing column index "0" and row index "5"
    #first value is between 0-2, and needs to be the same as value in next step search value
    #second value can be random from 0-5

    When I choose search value in column "0" and return value in column "2"
    #can be either index from 0-2 or column name (Country, Contact, Name)
    Then I verify the cell text with my text "Italy"

  Scenario: User go to table website and search for a value by XPath
    Given I go to the table website and get table

    Then I choose by xpath in row "2" and in column "1"
    #First value between 2-6
    #second value between 1-3
    Then I verify the cell text with my text "Alfreds Futterkiste"
