Feature: Test Forms LifeRay

  Scenario Outline: Validate Forms Liferay
    Given I Open chrome and start application
    When I Validate if rock text is diplayed
    When I fill in the required fields "<name>" "<date>" "<message>" and click in submit
    Then I Validate if the message of success is showup

    Examples: 
      | name  | date     | message     |
      | name1 | 07271992 | test 1233   |
      | name2 |          | test 12334  |
      | name3 | 07271993 |             |
      |       | 07271994 | test 123345 |
