Feature: Card Transaction Page Automation

  Scenario Outline: Perform card transaction and print response data
    Given I am in card transaction page
    When I change the currency to '<currency>'
    And I change the scope to '<scope>'
    And I switch to IFrame of Card details
    And I fill in the card details "<cardNumber>" "<expiryDate>" "<cvv>"
    And I generate the token
    And I wait until the '3ds' page is opened
    And I click on submit button
    And I wait until data exists in the response tab
    Then I print the transaction details

    Examples:
      | currency | scope               | cardNumber       | expiryDate | cvv |
      | BHD      | Authenticated Token | 5123450000000008 | 01/39      | 100 |
      | BHD      | Authenticated Token | 4508750015741019 | 01/39      | 100 |

