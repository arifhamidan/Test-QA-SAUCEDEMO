Feature: Login

  Scenario: Login as invalid username

    Given user should be open https://www.saucedemo.com/
    When user input invalid username and password
    And click button Login
    Then home page should not be displayed