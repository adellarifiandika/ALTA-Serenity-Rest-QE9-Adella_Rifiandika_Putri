Feature: Post Create New User

  #positive case
  @Latihan
  Scenario: Post create new user with valid json file
    Given Create new user with valid json
    When Send request post create user
    Then Status code should be 201 Created
    And Response body name should be "Adella Rifiandika" and job is "QA Engineer"
    And Validate post create new user json schema

  #negative case
  @Tugas
  Scenario: Post create new user with invalid json
    Given Post create user with invalid json
    When Send request post create user
    Then Should return status code 400 Bad Request