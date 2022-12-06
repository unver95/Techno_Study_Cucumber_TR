#Senaryo :
#  Daha önceki Create a Fee, delete Fee Senaryosunu
#  name, code, intCode ve priority için 5 farklı kombinasyon için çalıştırınız.


Feature: Fee Functionality (DataTable - Scenerio Outline)

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario Outline: Fee Functionality
    And Click on the element in left nav
      | setupOne   |
      | parameters |
      | feesSetup  |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput       | <name>     |
      | codeInput       | <code>     |
      | integrationCode | <intCode>  |
      | priorityCode    | <priority> |

    And Click on the element in the Dialog
      | toggleBar  |
      | saveButton |

    Then Success message should be displayed

    And User delete item from Dialog
      | <name> |

    Then Success message should be displayed

    Examples:
      | name        | code     | intCode     | priority |
      | IsmetFee115 | 01001121 | paypal13    | 9421     |
      | IsmetFee215 | 01002220 | applePay13  | 9651     |
      | IsmetFee315 | 02331331 | googlePay13 | 9531     |
