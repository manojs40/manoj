Feature: Zomato Pizza Price Search
Scenario: User login on Zomato and search pizza
    Given User is on Zomato login page for search pizza
    When User enters valid Email
    When User send otp for search pizza
    When User Verify the otp for pizza
    When User have login and set current location
    When User search pizza in search bar
  	Then User select first restaurant