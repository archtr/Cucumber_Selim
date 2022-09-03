Feature: Entrance Exam Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly

  Scenario Outline: Create and Delete a Exam
    And Click on the element in the left Nav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | <ExamName> |

    And Click on the element in the Form Content
      | academicPeriod         |
      | <AcademicPeriodOption> |
      | gradeLevel             |
      | <GradeLevelOption>     |

    And Click on the element in the Dialog
      | saveButton |

    Then Success message should be displayed

    And Click on the element in the left Nav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    When User delete item from Dialog
      | <ExamName> |

    Then Success message should be displayed
    Examples:
      | ExamName           | AcademicPeriodOption | GradeLevelOption |
      | Math exam selim1   | academicPeriod1      | gradeLevel2      |
      | IT exam selim1     | academicPeriod1      | gradeLevel2      |
      | Oracle exam selim1 | academicPeriod1      | gradeLevel2      |
      | Math exam  selim1  | academicPeriod1      | gradeLevel2      |


