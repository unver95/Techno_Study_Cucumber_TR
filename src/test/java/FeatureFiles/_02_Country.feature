Feature: Country Functionality

  Scenario:Create Country
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully
    And Navigate to country page
    When create a country
    Then hen Success message should be displayed
