Feature: Post Register User

  #positive case
  @Tugas
  Scenario: Register users with valid json
    Given Register new users with valid json
    When Send request register users
    Then Should return status code 200 OK
    And Validate json schema success register user

  #negative case
  @Tugas
  Scenario: Register users with invalid json
    Given Register new users with invalid json
    When Send request register users
    Then Should return status code 400 Bad Request
    And Response body error should be "Missing password"
    And Validate json schema failed register user
