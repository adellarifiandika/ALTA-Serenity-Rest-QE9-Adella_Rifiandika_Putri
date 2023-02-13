Feature: Post Login User
  #positive case
  @Tugas
  Scenario: Login user with registered users and match input email and password
    Given Login user with valid json file
    When Send request post login user
    Then Should return status code 200 OK
    And Validate post login successful json schema

  #negative case
  @Tugas
  Scenario: Login user with registered users and input blank in password
    Given Login user with invalid json file
    When Send request post login user
    Then Should return status code 400 Bad Request
    And Response body error should be "Missing password"
    And Validate post login unsuccessful json schema