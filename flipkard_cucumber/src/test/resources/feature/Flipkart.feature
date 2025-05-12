Feature: Flipkart Search Suggestion

  Scenario: User searches for T-shirt and prints suggestions
    Given I launch the browser and open Flipkart website
    When I search for "T-shirt" in the search bar
    Then I print all the search suggestions
    And I click on the first search suggestion