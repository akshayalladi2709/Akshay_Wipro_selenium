Feature: Search using all categories option
@Priority6      
  Scenario: User selects "All Categories" and searches
    Given the user is on eBay homepage to shop by all categories
    When the user selects all categories and performs search
    Then search results from all categories should appear
