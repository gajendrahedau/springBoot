Feature: Withdraw Feature
User will be able to withdraw amount using this feature

Scenario: User wants to withdraw using correct details
Given User is in 'withdraw amount' page
When User enters correct details
Then 'updated balance' is displayed on the page

Scenario: User wants to withdraw using incorrect details
Given User is in 'withdraw amount' page
When User enters incorrect details
Then user asked again to enter the details
