Feature: Note on Dashboard

  @report
  Scenario: Post a note on Dashboard
    Given I logged into suiteCRM
    When I post "Its Thursday"
    Then Post should be displayed
    Then I logout from application

  @report
  Scenario: Post another note on Dashboard
    When I post "Hello all"
    Then Post should be displayed
    And I logout from application
