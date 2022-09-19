Feature: ApachePOI Citizen Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly
    And Navigate to Citizenship page

    Scenario: Create Citizenship from Excel
      When User Create CitizenShip with ApachePOI

    Scenario: Delete Citizenship from Excel
      Then User Delete CitizenShip with ApachePOI