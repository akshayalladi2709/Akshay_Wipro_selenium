Feature: Add item to cart and then remove it
@Priority3   
  Scenario: User adds an item to cart and deletes it
    Given the user is on the eBay homepage to add and remove item
    When the user adds and removes an item from the cart
    Then the cart should not contain the item
