@ctivity2
Feature: Login Tests 
@validlogin
Scenario: Valid login test 
    Given the user is on the login page
    When they enter the valid username and password 
    And click the submit button
    Then they are redirected to the login success page 
@invalidlogin    
Scenario: Invalid login test 
    Given the user is on the login page
    When they enter the Invalid username and password
    And click the submit button
    Then the page displays an eoor message 