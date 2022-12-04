Feature:  Country Multi Scenario

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully
    And Navigate to country page

  Scenario: Create Country
    When create a country
    Then Success message should be displayed

  Scenario: Create Country parameter data
    When Create a country name as "sxyUlk1" code as "sxy"
    Then Success message should be displayed