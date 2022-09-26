#it is user story
Feature: Sign up Functionally
  #test description. It means what you are going to test here
  Scenario: Creating and Deleting user
    Given User navigates to the automationExercise webpage
    And User validates the url of the page
    When User clicks signUp button
    Then User verifies New User signUp is visible
    And User enters name, email address and click signUp button


