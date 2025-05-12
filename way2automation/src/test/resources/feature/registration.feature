Feature: Way2Automation Registration Form

Scenario: User fills the registration form with valid details
 Given I launch the browser and open the registration page
  When I enter first name as "Manoj"
  And I enter last name as "Kumar"
  And I select marital status as "Single"
  And I select hobbies as "Dance, Reading"
  And I select country as "India"
  And I select DOB with month "April", day "10", year "1995"
  And I enter phone number as "9876543210"
  And I enter username as "manojtest"
  And I enter email as "manoj@example.com"
  And I upload profile picture from "C:\\Users\\GOVINDA COMP YEOLA\\Pictures\\Screenshots\\profilepic.jpg"
  And I enter about yourself as "Manual Tester with automation knowledge"
  And I enter password as "Test@123"
  And I confirm password as "Test@123"
  Then I click the submit button