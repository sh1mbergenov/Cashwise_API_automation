Feature: user should be able to create a category
  @createCategory1
  Scenario: verify user successfully creates a category
    Given base url "https://backend.cashwise.us/api/myaccount"
    And I have access
    And I have the endpoint "/categories"
    And I have a "category_title" with "Foods" in request body
    And I have a "category_description" with "Foods and Drinks" in request body
    And I have a "flag" with "true" in request body
    When I send POST request
    Then verify status code is 201


@createCategory2
 Scenario Outline: verify flag accepts only boolean
    Given base url "https://backend.cashwise.us/api/myaccount"
    And I have access
    And I have the endpoint "/categories"
    And I have a "category_title" with "Foods" in request body
    And I have a "category_description" with "Foods and Drinks" in request body
    And I have a "flag" with "<valueOfFlag>" in request body
    When I send POST request
    Then verify status code is 500
  Examples:
    | valueOfFlag |
    | real madrid |
    | falsssse    |
    | empty       |
    |             |
    | 200         |


  @createCategory3
  Scenario Outline: verify category title does not accept more then 250 chars
    Given base url "https://backend.cashwise.us/api/myaccount"
    And I have access
    And I have the endpoint "/categories"
    And I have a "category_title" with "<valueOfTitle>" in request body
    And I have a "category_description" with "Foods and Drinks" in request body
    And I have a "flag" with "true" in request body
    When I send POST request
    Then verify status code is 500
    Examples:
      | valueOfTitle |
      |              |

  @createCategory4
  Scenario: verify user successfully creates a category
    Given base url "https://backend.cashwise.us/api/myaccount"
    And I have access
    And I have the endpoint "/categories"
    And I have a "category_title" with "Cars" in request body
    And I have a "category_description" with "Machine and Cars" in request body
    And I have a "flag" with "true" in request body
    When I send POST request
    Then verify status code is 201
    Then I delete "Cars" category in database
    Then verify "Cars" is deleted from database using GET request