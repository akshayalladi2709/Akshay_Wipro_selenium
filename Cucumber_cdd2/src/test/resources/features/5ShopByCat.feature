Feature: Hover over and explore top categories
@Priority5     
  Scenario: User explores different categories
    Given the user is on the eBay homepage to explore categories
    When the user hovers over different categories
    Then the subcategories should be displayed
