Feature: check user is able to login with valid credetials
Scenario: successful login
Given login page should be open in default browser
When click on username button and enter valid username
And add password
And click on signin button
Then login successfully and open home page