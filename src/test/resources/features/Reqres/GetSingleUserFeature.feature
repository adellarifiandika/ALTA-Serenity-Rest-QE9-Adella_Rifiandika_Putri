Feature: Get Single User

  #positive case
  @Tugas
  Scenario Outline: Get single user with valid parameter id
    Given Get single user with valid parameter id <id>
    When Send request get single user
    Then Status code should be 200 OK
    And Validate get single user json schema
    Examples:
      | id |
      | 1  |
      | 2  |

  #negative case
  @Tugas
  Scenario Outline: Get single user with invalid parameter id
  Given Get single user with invalid parameter id "<id>"
  When Send request get invalid single user
  Then Status code should be 404 Not Found
  Examples:
    | id   |
    | xyz  |
    | **^% |
