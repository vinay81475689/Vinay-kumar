@activity4
Feature: Testing Javascript Alerts

  Scenario Outline: Test for handling Alerts
    Given the user is on the Alerts page
    When the user clicks on the "<Alert>" alert
    Then an alert is visible
    And the user clicks the "<CloseWith>" button
    And check if the message contains "<MessageContains>"

    Examples:
      | Alert        | CloseWith | MessageContains |
      | simple       | OK        | accepted        |
      | confirmation | OK        | accepted        |
      | confirmation | Cancel    | dismissed       |

  Scenario: Test for the prompt alert
	Given the user is on the Alerts page
	When the user clicks on the "prompt" alert
	Then an alert is visible
	And the user types "testMessage" in the prompt
    And the user clicks the "OK" button
    And check if the message contains "testMessage"