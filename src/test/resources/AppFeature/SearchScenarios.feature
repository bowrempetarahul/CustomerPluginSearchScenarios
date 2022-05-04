Feature: Nyp Search Scenarios

  Scenario: Search Page Title Check
    Given navigate to Search Page
    When identify Search Page title
    Then page title should be "Search Results | NYP"

  Scenario: WildCard Asterisk Check
    Given navigate to Search Page
    When Provide Search Input "test*"
    Then Search Results Should Display "test"

  Scenario: WildCard Question Check
    Given navigate to Search Page
    When Provide Search Input "t?st"
    Then Search Results Should Display "test"