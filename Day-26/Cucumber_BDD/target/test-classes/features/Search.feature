Feature: check user is able to login with valid credentials
Scenario: Check search button is working or not
  Given login user and search button available
  When click on search button
  And Enter inputs and then use keyboard enter key
  Then List of output relevant to inputs