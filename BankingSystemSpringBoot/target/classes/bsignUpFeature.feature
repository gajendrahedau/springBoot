Feature: CG Banking Sign UpFeature
Using this feature user can create a new banking account

Scenario: User want to signup by entering his credentials
Given User is on Banking Signup Page
When User submits valid details
Then Register the user

Scenario: User want to signup by entering valid credentials
Given User is on Banking SignUp Page
When User submits invalid details 
Then Ask to fill correct details

