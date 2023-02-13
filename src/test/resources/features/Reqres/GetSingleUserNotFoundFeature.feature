Feature: Get Single User Not Found

  #positive case
  @Tugas
  Scenario Outline: Get single user not found with valid parameter id
    Given Get single user not found with valid paramater id <id>
    When Send request get single user not found
    Then Status code should be 404 Not Found
    And Validate get single user not found json schema
    Examples:
      | id |
      | 23 |

  #negative case
  @Tugas
  Scenario Outline: Get single user not found with invalid parameter id
     Given Get single user not found with invalid paramater id <id>
     When Send request get single user not found
     Then Status code should be 404 Not Found
     And Validate get single user not found json schema
     Examples:
       | id |
       | 23 |