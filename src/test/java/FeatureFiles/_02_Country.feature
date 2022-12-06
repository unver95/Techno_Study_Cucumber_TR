Feature: Country Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully
    And Navigate to country page

    @SmokeTest
  Scenario: Create Country

    When create a country
    Then Success message should be displayed