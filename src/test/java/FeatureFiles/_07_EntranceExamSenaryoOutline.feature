#Senaryo :
#  Bir önceki Exam Giriş Senaryosunu
#  Aşağıdaki değerler için çalıştırınız.
#
#| ExamName        | AcademicPeriodOption         | GradeLevelOption |
#| Math exam is1   | academicPeriod1              | gradeLevel2  |
#| IT exam is1     | academicPeriod1              | gradeLevel3  |
#| Oracle exam is1 | academicPeriod1              | gradeLevel4  |
#| Math exam  is1  | academicPeriod1              | gradeLevel5  |


Feature: Exam Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario Outline: Create and Delete Exam
    And Click on the element in left nav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | <ExamName> |

    And Click on the element in the Form Content
      | academicPeriod         |
      | <academicPeriodOption> |
      | gradeLevel             |
      | <gradeLevelOption>     |

    And Click on the element in the Dialog
      | saveButton |

    Then Success message should be displayed

    And Click on the element in left nav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And User delete item from Dialog
      | <ExamName> |

    Then Success message should be displayed

    Examples:
      | ExamName                                          | academicPeriodOption | gradeLevelOption |
      | Math exam is1133                                  | academicPeriod1      | gradeLevel2      |
      | IT exam is1313                                      | academicPeriod1      | gradeLevel3      |
      | Oracle exam is1331                                  | academicPeriod1      | gradeLevel4      |
      | senaexam1111111113311111111111111111111111111111111 | academicPeriod1      | gradeLevel5      |