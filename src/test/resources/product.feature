@regression
Feature: creates a product
    Background:
      Given base url "https://backend.cashwise.us/api/myaccount"
      @createProduct @smoke
  Scenario: user successfully creates a product
    And I have access
    And I have the endpoint "/products"
    And I have a "product_title" with "ancient1" in request body
    And I have a "product_price" with "15.99" in request body
    And I have a "service_type_id" with "1" in request body
    And I have a "category_id" with "2" in request body
    And I have a "product_description" with "ancient1" in request body
    And I have a "date_of_payment" with "2024-05-29" in request body
    And I have a "remind_before_day" with "2" in request body
    And I have a "do_remind_every_month" with "REPEAT_EVERY_MONTH" in request body
    When I send POST request
    Then verify status code is 201
    Then verify I have "product_title" with "ancient1" in response body
      Then I delete the product
@smoke
  Scenario: user unsuccessfully creates a product
    And I have access
    And I have the endpoint "/products"
    And I have a "product_title" with "smoke12345" in request body
    And I have a "product_price" with "15.99" in request body
    And I have a "service_type_id" with "1" in request body
    And I have a "category_id" with "2" in request body
    And I have a "product_description" with "null" in request body
    And I have a "date_of_payment" with "2024-05-29" in request body
    And I have a "remind_before_day" with "2" in request body
    And I have a "do_remind_every_month" with "REPEAT_EVERY_MONTH" in request body
    When I send POST request
    Then verify status code is 201
    Then verify I have "product_title" with "smoke12345" in response body
    Then I delete the product

@dbTest1 @smoke
  Scenario: user successfully creates a product , verify product in DB
    And I have access
    And I have the endpoint "/products"
    And I have a "product_title" with "cache1" in request body
    And I have a "product_price" with "17.99" in request body
    And I have a "service_type_id" with "1" in request body
    And I have a "category_id" with "2" in request body
    And I have a "product_description" with "cache1" in request body
    And I have a "date_of_payment" with "2024-05-29" in request body
    And I have a "remind_before_day" with "2" in request body
    And I have a "do_remind_every_month" with "REPEAT_EVERY_MONTH" in request body
    When I send POST request
    Then verify status code is 201
    Then verify I have "product_title" with "cache1" in response body
    And verify "product title" with "cache1" is in database
    Then I delete the product
    Then verify "product title" with "cache1" is not in database









