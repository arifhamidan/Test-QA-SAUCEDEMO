Feature: Login

  Scenario: Login as valid username

    Given user should be open https://www.saucedemo.com/ in web browser
    When user input valid username and password
    And user click button Login
    Then home page should be displayed