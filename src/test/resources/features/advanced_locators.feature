Feature: Advanced Locators Handling

  Scenario: Access Shadow DOM and use Dynamic XPath
    Given the browser is open
    When the user navigates to the shadow DOM page
    Then the user interacts with the shadow element
    And the user interacts with element using dynamic xpath
