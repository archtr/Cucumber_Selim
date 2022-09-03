Feature: Country Multi Scenario

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly
    And Navigate to Country Page

  Scenario: Create a country
    When Create a Country
    Then Success message should be displayed

    Scenario: Create a country parameter data
      When Create a country name as "selimYeni1" code as "code1"
      Then Success message should be displayed