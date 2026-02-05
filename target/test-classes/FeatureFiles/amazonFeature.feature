Feature: Access Amazon application 

@Login @category
Scenario Outline: Login with valid credentials
Given Launch the url "<url>"
When I enter the valid "<Username>" and "<Password>"
Then User should be able to login successfully and validate

Examples:
|Username  |Password   |url                   | 
|9944937157|Vishnu@1927|https://www.amazon.in/|
 

@category
Scenario Outline: Access the amazon categories
Given Accessing the list of categories "<datarow>" 
When Clicking on the selected image
#Then Logout application
And Write the retreived data in property file

Examples:
|datarow|
|1      |
|2      |