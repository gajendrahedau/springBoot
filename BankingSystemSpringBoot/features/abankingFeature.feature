Feature: CG Banking Feature
Using this feature user can able to use banking services

Scenario: User want to login by entering valid credentials
Given User is on Banking Home Page
When User clicks on 'LogIn' 
Then Link should display with 'Log In'

Scenario: User want to signup by entering valid credentials
Given User is on Banking Home Page
When User clicks on 'New USer? Sign Up' 
Then Link should display with 'Sign Up'