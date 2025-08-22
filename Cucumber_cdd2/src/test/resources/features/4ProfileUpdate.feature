Feature: Update address and name in eBay profile
@Priority4    
  Scenario: User updates profile address and middle name
    Given the user is logged in to update address
    When the user updates address and name in account settings
    Then the updated profile information should be saved
