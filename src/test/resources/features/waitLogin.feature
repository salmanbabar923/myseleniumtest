Feature: Dynamic Wait Example

  Scenario: Wait for finish element to be visible
    Given the browser is open
    When the user navigates to dynamic loading page
    And the user clicks the start button
    Then wait until the Hello World message is visible
