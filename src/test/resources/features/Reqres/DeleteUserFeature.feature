Feature: Delete User

  #positive case
  @Latihan
  Scenario Outline: Delete user with valid parameter id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Status code should be 204 No Content
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |

  #negative case
  @Tugas
  Scenario Outline: Delete user with unregister user id
    Given Delete user with invalid id <id>
    When Send request delete user
    Then Status code should be 404 Not Found
    Examples:
      | id |
      | 13 |