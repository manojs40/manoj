Feature: Rediffmail_registration

  Scenario: User fills registration form with valid details
    Given I launch the Chrome browser
    And I open the Rediffmail registration page
    When I enter first name as "Manoj"
    And I enter email ID as "manojtest123"
    And I enter password as "Test@123"
    And I re-enter password as "Test@123"
    And I enter alternate email as "manoj.alt@example.com"
    And I select day as "10", month as "APR", and year as "1995"
    And I select gender as "Male"
    And I enter mobile number as "9876543210"
    Then I click on the Create My Account button
