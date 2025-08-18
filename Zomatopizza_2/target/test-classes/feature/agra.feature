Feature: Zomato Pizza Search in Agra

  Scenario: User searches for Pizza in Agra Restaurants
    Given User launches the browser
    When User opens the Zomato India homepage
    And User clicks on "Agra Restaurants"
    And User searches for "Pizza" in the search bar
    Then Pizza search results should be displayed
