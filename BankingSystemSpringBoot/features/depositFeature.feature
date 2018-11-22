Feature: Deposit Amount Feature
Using this feature user will be able to deposit in the account

Scenario: User wants to deposit using correct details
Given User is in 'deposit amount' page
When User enters his correct details
Then 'updated balance' is displayed to user

Scenario: User wants to deposit using incorrect details
Given User is in 'deposit amount' page
When User enters his incorrect details
Then user  is asked again to enter the details
