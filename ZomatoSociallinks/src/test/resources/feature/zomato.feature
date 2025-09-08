Feature: Social links on Zomato India Home Page

  As a visitor to the Zomato India website
  I want to click on the Instagram social icon
  So that I am redirected to Zomato’s Instagram page

  Background:
    Given I am on the Zomato India home page

  Scenario: Clicking on Instagram social link navigates to Instagram page
    When I click the "Instagram" social link
    Then I should be redirected to "https://www.instagram.com/zomato/"
