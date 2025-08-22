Feature: eBay Login
@Priority1   
  Scenario: User logs in with valid credentials
    Given the user navigates to the eBay login page
    When the user enters their email and password
    Then the user should be signed in successfully
