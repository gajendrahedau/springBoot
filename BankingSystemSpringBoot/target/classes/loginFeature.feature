Feature: CG Banking Log In Feature
Using this feature user canlog in to his banking account

Scenario: User want to login by entering his credentials
Given User is on Banking Login Page
When User submit valid details
Then User is able to login

Scenario: User want to login by entering invalid credentials
Given User is on Banking Login Page
When User submit invalid details
Then Display error to user
