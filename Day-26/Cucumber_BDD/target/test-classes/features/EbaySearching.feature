Feature: Multiple Items
Scenario Outline: Searching Multiple items
Given Page should be opened in browser
When Enter <products> and then enter
Then items should be displayed
Examples:
|products|
|Watch|
|shoes|
|phone|
|Camera|