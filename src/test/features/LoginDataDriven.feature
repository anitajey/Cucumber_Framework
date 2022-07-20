#@regression
Feature: LoginDataDriven_feature
  Background:
    Given I am on Home Page
    When I click on SIGN IN link
    Then I should be on the authentication page

  #Unhappy path scenario
  #Scenario outline basically replaces variable/keywords with the value from the table
 #Verify user cannot Login with blank Email and blank  Password
#@smoke
  Scenario Outline: Verify user cannot login with invalid credentials and can see validation message
    When I enter the Email Address as <username> Password as <password>
    And I click on the SIGN IN button
    Then I should be on the authentication page
    And I should see validation message <validation_message>

    Examples:
      | username                      | password              | validation_message  |
      |testaccount123@mailinator      |Pass                   |Invalid email address.|
      |testaccount123@mailinator      |Password123            |Invalid email address.|
      |testaccount123@mailinator.com  |Pass                   |Invalid password.|
      |                               |Password123            |An email address required.|
      |testaccount123@mailinator.com  |                       |Password is required.|
      |                               |                       |An email address required.|
