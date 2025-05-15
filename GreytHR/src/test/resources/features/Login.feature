Feature: Greythr Login Page Automation

  Scenario: Successful Login with Valid Credentials
    Given the user is on the Greythr login page
    When the user enters valid credentials
    And clicks the login button
    Then the user should be redirected to the dashboard page
