@regression
Feature: WebOrder page food Order Functionality
Background: Until invite list
  #Given User navigates to the 'https://demo.weborder.net'
  And User provides valid username 'guest1@microworks.com' and 'Guest1!'
  When User validates the title 'ORDER DETAILS - Weborder' from homepage
  And User click Group Order Box and Next Button
  And User sends the word 'test'
  And User sends e-mail addresses which are 'ahmet@gmail.com' and 'mustafa@gmail.com' to Invite List

  Scenario: Testing WebOrder functionality for House
    And User chooses the delivery address 'My House' and validate the address '3137 Laguna Street'
    And User clicks create group order button
    Then User validates the header of page which is 'View Group Order'
    And User validates total participant is 1

  Scenario: Testing WebOrder functionality for Office
    And User chooses the delivery address 'Office' and validate the address '2012 EMPIRE BLVD'
    And User clicks create group order button
    Then User validates the header of page which is 'View Group Order'
    And User validates total participant is 1





