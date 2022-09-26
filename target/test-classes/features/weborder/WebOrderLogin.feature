@regression
Feature: Login Functionality of WebOrder Page

  #Background is acting like @BeforeMethod from TestNG
#  Background: Navigation to the website
#    #Given User navigates to the 'https://demo.weborder.net'
##  @smoke @ahmet @mehmet
#  Scenario: Validation of WebOrder Login Page(Happy Path)
#    #Given User navigates to the 'https://demo.weborder.net'
#    When User provides valid username 'guest1@microworks.com' and 'Guest1!'
#    Then User validates the title 'ORDER DETAILS - Weborder' from homepage
##  @smoke @ahmet
#  Scenario: Validation of WebOrder Login Page(Correct Username Wrong password)
#    #Given User navigates to the 'https://demo.weborder.net'
#    When User provides valid username 'guest1@microworks.com' and 'dfdfd!'
#    Then User validates the message 'Sign in Failed' from login page
#
#  Scenario: Validation of WebOrder Login Page(Wrong Username Correct password)
#   # Given User navigates to the 'https://demo.weborder.net'
#    When User provides valid username 'asdsdsd@gmail.com' and 'Guest1'
#    Then User validates the message 'Sign in Failed' from login page
#
#  Scenario: Validation of WebOrder Login Page(empty Username Empty password)
#   # Given User navigates to the 'https://demo.weborder.net'
#    When User provides valid username '' and ''
#    Then User validates the message 'Sign in Failed' from login page
  @regression
  Scenario Outline: Validation of WebOrder Login Page(empty Username Empty password)
    When User provides valid username '<username>' and '<password>'
    Then User validates the message '<message>' from login page

    Examples:
      | username                   | password    | message        |
      | guest1@microworks.com      | dfdfd!      | Sign in Failed |
      | asdasdm                    | Guest1!     | Sign in Failed |
      |                            | Guest1!     | Sign in Failed |
      |                            |             | Sign in Failed |
      | guest1@microworks.com      | Guest1!     | Sign in Failed |
      | !@#@#$#$%$^%^@yahoo.com    | %^%$^%&%^&  | Sign in Failed |
      | !@#@#$#$%$^%^^$%@gmail.com | %^%$^%&%^&  | Sign in Failed |
      | !@#@#$#$%$^%^^$%@gmailcom  | adsfsdfdfgf | Sign in Failed |
      | 1233434343243234@gmailcom  | adsfsdfdfgf | Sign in Failed |
      | GUEST1@MICROWORKS.COM      | Guest1!     | Sign in Failed |
      | GUEST1@MICROWORKS.COM      | GUEST1!     | Sign in Failed |









