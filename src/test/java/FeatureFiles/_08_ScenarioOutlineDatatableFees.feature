#  Daha önceki Create a Fee, delete Fee Senaryosunu
#  Aşağıdaki 5 farklı değerler için çalıştırınız.

Feature: Fee Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly

  Scenario Outline: Create a Fee , Delete a Fee

    And Click on the element in the left Nav
      | setupOne   |
      | parameters |
      | fees       |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput       | <name>     |
      | codeInput       | <code>     |
      | integrationCode | <intCode>  |
      | priorityCode    | <priority> |
    And Click on the element in the Dialog
      | saveButton |
    And Success message should be displayed

    And User delete item from Dialog
      | <name> |
    And Success message should be displayed
    Examples:
      | name  | code | intCode | priority |
      | slm11 | 11   | s123     | 234      |
      | slm12 | 12   | s123     | 2345     |
      | slm13 | 13   | s123     | 2346     |
      | slm14 | 14   | s123     | 2347     |
      | slm15 | 15   | s123     | 2348     |

