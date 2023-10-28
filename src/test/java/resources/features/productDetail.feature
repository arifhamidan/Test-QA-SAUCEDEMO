Feature: Product Detail

  Scenario: Show Product Detail
    Given user success login in https://www.saucedemo.com/
    When user click Name Product in list first product
    Then show to page product detail which user choosen