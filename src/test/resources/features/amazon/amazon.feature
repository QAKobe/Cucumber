#@production
Feature: Testing Amazon Functionality

  Scenario: Happy path Amazon Search Functionality
    Given User navigates to the Amazon
    When User searches for Seiko
    Then User validates the number is fifty thousands result
    And User validates all headers contains Seiko
