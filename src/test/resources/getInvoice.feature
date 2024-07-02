Feature: end to end scenario to validate invoice on API and DB
  @getInvoice
  Scenario: verify invoice details are displayed accurately
    Given base url "https://backend.cashwise.us/api/myaccount"
    And I have access
    And I have the endpoint "/invoices/422"
    And I have "page" with "1" as query param
    And I have "size" with "10" as query param
    When I send GET request
    Then verify status code is 200
    Then verify I have "invoice_title" with "Practical Plastic Lamp" in response body
    And verify the invoice details in the response match the database