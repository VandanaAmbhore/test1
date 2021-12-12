Feature: To test the Reqres site with REST assured
Background:
Given Uer is authenticated

Scenario: Get the list of users
Given url "https://reqres.in/api/users?page=2"
When user is using Get method
Then user will get the list of users
Then response content type is "json"
And respone status line is "HTTP/1.1 200 OK"
Then get response in less than 3000 ms



