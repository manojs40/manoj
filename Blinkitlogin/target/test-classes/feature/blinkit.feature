Feature: Blinkit Login Module

  Scenario: User logs in with valid mobile number
    Given I am on the Blinkit home page
    When I click on the Login button
    And I enter mobile number "8421295968"
    And I click on the Continue button
    Then I should see the OTP verification screen
