@smart
Feature: Web order functionality
#  Scenario: creating order function
#    When User enters username and password and clicks loging button
#    Then User clicks order button
#    And User chooses 'ScreenSaver' and provides quantity as '100'
#    Then User provides his or her 'Kuan' and 'Abdy'
#    And User provides 'river rd' and 'chicago'
#    Then User provides 'Il' and '60656' and fills it
#    And User checks visa
#    And User provides '1233434234' and '12/22' and clicks proceed button
#    Then User validates 'New order has been successfully added.' at the end

#  Scenario Outline: creating order function
#    When User enters username and password and clicks loging button
#    Then User clicks order button
#    And User chooses '<productName>' and provides quantity as '<quantity>'
#    Then User provides his or her '<customerName>' and 'Abdy'
#    And User provides '<street>' and '<city>'
#    Then User provides '<state>' and '<zipcode>' and fills it
#    And User checks visa
#    And User provides '<cardNumber>' and '<expDate>' and clicks proceed button
#    Then User validates '<New order has been successfully added.>' at the end
#
#    Examples:
#      | productName | quantity | customerName | street     | city        | state | zipcode | cardNumber | expDate |
#      | MyMoney     | 4        | Ahmet        | MidwayDr   | Mt Prospect | IL    | 60656   | 546456546  | 07/23   |
#      | ScreenSaver | 100      | Kuan         | River Rd   | Chicago     | IL    | 60625   | 2323233    | 04/24   |
#      | FamilyAlbum | 34       | Kuan         | Cumberland | Norridge    | IL    | 60625   | 2323233    | 04/24   |

  Scenario: creating order function
    When User enters username and password and clicks loging button
    Then User clicks order button
    And User chooses and provides quantity as
      | productName | MyMoney |
      | Quantity    | 4       |
    Then User provides his and info
      | customerName | Ahmet |
    And User provides  and
      | street | MidwayDr    |
      | city   | Mt Prospect |
    Then User provides  and  and fills it
      | state   | Il    |
      | zipcode | 60656 |
    And User checks visa
    And User provides  and  and clicks proceed button
      | cardNumber | 54354353 |
      | expDate    | 07/23    |
    Then User validates at the end
      | New order has been successfully added. |