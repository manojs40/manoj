Feature: Location search on Zomato

  Scenario: User searches for Mumbai in location field
    Given I am on the Zomato India home page
    When I click on the location field
    And I type "Mumbai" in the location field
    And I select "Mumbai" from the dropdown
    Then  I should be navigated to the "Mumbai" Zomato page