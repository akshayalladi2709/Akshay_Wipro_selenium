Feature: Change language or country on eBay
@Priority7     
  Scenario: User changes the country to Italy
    Given the user is on the eBay homepage to change language
    When the user scrolls down and changes country to Italy
    Then the site should switch to Italian version
