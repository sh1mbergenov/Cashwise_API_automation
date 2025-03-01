Feature: creates a invoice

  Background:
    Given base url "https://backend.cashwise.us/api/myaccount"

  @createInvoice
  Scenario: user successfully creates a product
    And I have access
    And I have the endpoint "/invoices"
    And I have "invoice_title" with "Lagman Invoice" in request body
    And I have "client_id" with "2" in request body
    And I have "date_of_creation" with "2024-06-03" in request body
    And I have "end_date" with "2024-07-03" in request body
    And I have "products" with product
    And I have "sum" with "15.99" in request body
    And I have "discount" with "0" in request body
    And I have "sum_of_discount" with "0" in request body
    When I send POST request
    Then verify status code is 201
    And verify I have "invoice_title" with "Lagman Invoice" in response body