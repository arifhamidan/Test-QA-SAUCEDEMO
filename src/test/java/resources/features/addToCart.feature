Feature: Add To Cart

  Scenario: Adding product to cart
    Given user login in https://www.saucedemo.com/
    When user click button Add to Cart in first list product
    And user click icon cart
    Then in cart page, will show product user which choose