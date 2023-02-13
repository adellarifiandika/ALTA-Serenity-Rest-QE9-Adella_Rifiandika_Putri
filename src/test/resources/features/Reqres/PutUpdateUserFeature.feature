Feature: Put Update User

  #positive case
  @latihan
  Scenario Outline: Put update users with valid json and valid parameter id
    Given Update users with valid json and parameter id <id>
    When Send request put update user
    Then Status code should be 200 OK
    And Response body name should be "Adella Rifiandika" and job is "QA Engineer"
    And Validate put update user json schema
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |

  #negative case
  @Tugas
  Scenario: Put update user with invalid json
    Given Put update user with invalid json with id 2
    When Send request put update user
    Then Should return status code 400 Bad Request