Feature: Place an order
  @smoke
  Scenario: using default payment option
    Given I'm a guest customer
    And my billing details are
      | firstname | lastname | country           | address_line1     | city  | state | zip   | email              |
      | demo      | user     | United State (US) | 6300 Soring Creek | Plano | Texas | 75024 | askomdch@gmail.com |
    And I have a product in the cart
    And I'm on the Checkout page
    When I provide billing details
    And i place an order
    Then The order should be placed successfully