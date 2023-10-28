Feature: Login Page saucedemo

  Scenario: Success Login
    Given Halaman login saucedemo
    When Input username
    And Input password
    And click login button
    Then user in on dashboard page

  Scenario: Success Login
    Given Halaman login saucedemo
    When Input username
    And Input Invalid password
    And click login button
    Then user get error message