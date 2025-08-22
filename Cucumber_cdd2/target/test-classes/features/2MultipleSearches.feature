Feature: Multiple item search on eBay
@Priority2   
  Scenario: User searches for multiple items one by one
    Given the user is on the eBay homepage
    When the user searches for "Watch","Phone","Shoes"
    Then the search results should be displayed for each item
