Feature: Datatable Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly

    Scenario: Create Country
      And Click on the element in the left Nav
        | setupOne    |
        | parameters  |
        | countries   |

      And Click on the element in the Dialog
        | addButton   |

      And User sending the keys in Dialog content
        | nameInput   | selimCountry111   |
        | codeInput   | 5454            |
      And Click on the element in the Dialog
        | saveButton   |
      And  Success message should be displayed

      And User delete item from Dialog
        | selimCountry111   |
      And Success message should be displayed

      Scenario: Create a Nationality
        And Click on the element in the left Nav
          | setupOne      |
          | parameters    |
          | nationalities |
        And Click on the element in the Dialog
          | addButton   |
        And User sending the keys in Dialog content
          | nameInput   | selimNat11   |
        And Click on the element in the Dialog
          | saveButton   |
        And Success message should be displayed

        And User delete item from Dialog
          | selimNat11   |
        And Success message should be displayed

        Scenario: Create a Fee , Delete a Fee
          And Click on the element in the left Nav
            | setupOne      |
            | parameters    |
            | fees |
          And Click on the element in the Dialog
            | addButton   |
          And User sending the keys in Dialog content
            | nameInput         | selimFee112   |
            | codeInput         | s11w2         |
            | integrationCode   | s11q2         |
            | priorityCode      | s11z2         |
          And Click on the element in the Dialog
            | saveButton   |
          And Success message should be displayed

          And User delete item from Dialog
            | selimFee112   |
          And Success message should be displayed



