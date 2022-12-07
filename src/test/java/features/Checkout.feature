Feature: Place the order for products

  @PlaceOrder2
  Scenario Outline: 2 Search experience for products search un both home and offers page
    Given user is on greenkart landing page
    When user searched with shortname <Name> and extracted actual name of the product
    And added "3" items of the selected product to cart
    Then user proceeds to checkout and validate the <Name> items in checkout page
    And verify user has ability to enter promo code and place the order

    Examples:
      | Name |
      | Tom  |





