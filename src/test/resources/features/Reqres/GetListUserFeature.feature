Feature: Get List user

  #positive case
  @Latihan
  Scenario Outline: Get list users with valid parameter page
    Given Get list users with valid parameter page <page>
    When Send request get list users
    Then Status code should be 200 OK
    And Response body page should be <page>
    And Validate get list user json schema
    Examples:
      |page|
      |1   |
      |2   |

  #negative case
  @Tugas
  Scenario Outline: Get list user with invalid parameter page
    Given Get list users with invalid page "<page>"
    When Send request get list users
    Then Status code should be 404 Not Found
    Examples:
      | page      |
      | #%^*      |
      | Ssdfghjyt |