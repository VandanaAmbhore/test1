@getJson
Feature: checking the json data
Background:
Given Uer is authenticated
Scenario: checking data of id 8
#Given user is authenticated
Given url "https://reqres.in/api/users"
#When user fires request on endpoint "https://reqres.in/api/users"
And query paramter is ID is 8
And user is using Get method
Then user is getting first name "Lindsay"