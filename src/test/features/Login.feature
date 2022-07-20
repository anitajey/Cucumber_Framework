#@regression
Feature: Login_Feature
  Background:
    Given I am on Home Page
    When I click on SIGN IN link
    Then I should be on the authentication page

#Happy path scenario
#@smoke
  Scenario: Verify user can Login successfully with valid credentials
    When I enter the Email Address as testaccount123@mailinator.com Password as Password123
    And I click on the SIGN IN button
    Then I should be LOGGED IN successfully
    And I should be on MY ACCOUNT page












