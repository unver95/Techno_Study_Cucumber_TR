Feature: Datatable Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario: Create Country
    And Click on the element on left nav
      | setupOne   |
      | parameters |
      | countries  |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | brkly6969 |
      | codeInput | bkrltCoty |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | brkly6969 |


  Scenario: Create a Nationality
    And Click on the element on left nav
      | setupOne      |
      | parameters    |
      | nationalities |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | brkly6969 |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | brkly6969 |

    Then Success message should be displayed


    #TODO : Create a fee, delete fee
  Scenario: Fee Functionality
    And Click on the element on left nav
      | setupOne   |
      | parameters |
      | feesSetup  |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput       | brkly6969 |
      | codeInput       | bkrltCoty |
      | integrationCode | 6969      |
      | priorityCode    | 69        |

    And Click on the element in the Dialog
      | toggleBar  |
      | saveButton |

    Then Success message should be displayed

    And User delete item from Dialog
      | brkly6969 |

    Then Success message should be displayed

       #    Senaryo Outline da verilen değerler için tüm senaryo her satır kadar tekrar çalıştırılıyordu.
       #    DataTable da ise, sadece ilgili step için toplu veri gönderme imkanı oluşuyor.

