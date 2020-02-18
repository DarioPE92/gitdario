Feature: Test Forms LifeRay

  Scenario Outline: Validate Forms Liferay
    Given Open chrome and start application
    When Validate if rock text is diplayed
    And fill in the required fields "<name>" "<date>" "<message>" and click in submit
    And Validate if the fields are filled
    Then Validate if the message of success is showup

    Examples: 
      | name  | date     | message     |
      | name1 | 07271992 | test 1233   |
      | name2 |          | test 12334  |
      | name3 | 07271993 |             |
      |       | 07271994 | test 123345 |
      |       |          |             |
