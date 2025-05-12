Feature: Facebook Login
 
  Scenario: Login with valid credentials in facebook
    Given User is on Facebook login page
    When User enters valid username and password
    Then Clicks on login button
   