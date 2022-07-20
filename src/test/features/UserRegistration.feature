@regression
Feature: User Registration
  Background:
    Given I am on Home Page
    When I click on SIGN IN link
    Then I should be on the authentication page

  @smoke
  Scenario Outline: Verify user is not able to Create An Account without providing mandatory fields
    When User enters email as "<email address>"
    And User clicks on Create An Account button
    Then User should be on Create An Account page
    When User provide title "<title>", first name "<first name>", last name "<last name>", password "<password>"
    And User selects DOB "<DOB>", month "<month>" and year "<year>"
    And User provides address as below:
      |20YaldenClose|
      |Wokingham|
      |12345|
    And User selects the state "<state>" and country "<country>"
    And User enter the mobile number "<mobile number>"
    And User clicks on register button
    Then User should see error message as "<error>"

    Examples:
      | email address     | title | first name | last name |  password    | DOB | month      | year | state  | country      | mobile number | error                    |
      |anita1111@gmail.com| Mrs.  |            | Jey       | Password123  | 11  | 11         | 2021 | Alabama| United States| 07804584686   | firstname is required.   |
      |anita1111@gmail.com| Mrs.  | Anita      |           | Password123  | 11  | 11         | 2021 | Alabama| United States| 07804584686   | lastname is required.    |
      |anita1111@gmail.com| Mrs.  | Anita      | Jey       |              | 11  | 11         | 2021 | Alabama| United States| 07804584686   | passwd is required.      |
      |anita1111@gmail.com| Mrs.  | Anita      | Jey       | Password123  | 11  | 11         | 2021 | Alabama| United States|               | You must register at least one phone number.  |