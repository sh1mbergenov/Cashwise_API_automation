Feature: verify user can update a category

  @createCategory1
  Scenario: verify user successfully creates a category
    Given base url "https://backend.cashwise.us/api/myaccount"
    And I have access
    And I have the endpoint "/categories"
    And I have a "category_title" with "Foods" in request body
    And I have a "category_description" with "KFC" in request body
    And I have a "flag" with "true" in request body
    When I send POST request
    And I retrieve id for "category_id"
    Then verify status code is 201
    And I have a "category_title" with "Cosmetics" in request body
    When I send PUT request
    Then verify status code is 200
    Then verify I have "category_title" with "Cosmetics"

  @updateCategory
  Scenario: verify user successfully updates category_title
    Given base url "https://backend.cashwise.us/api/myaccount"
    And I have access
    And I have the endpoint "/categories"
    And I have a "category_title" with "Foods" in request body
    And I have a "category_description" with "Foods and Drinks" in request body
    And I have a "flag" with "true" in request body
