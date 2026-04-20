@activity3
Feature: Parameterized example

  @parameterizedTest
  Scenario Outline: Login test
    Given The user is on the login page
    When they enter "<Username>" and "<Password>"
    And click the submit button
    Then the message displays "<Message>"

    Examples:
      | Username  | Password      | Message              |
      | wrongUser | wrongPassword | Invalid credentials  |
      | admin     | password      | Welcome Back, Admin! |
