Feature: Search by contact name
	
  Scenario: Search contact name
    Given I logged into suiteCRM
    When I search for "John Doe"
    Then link for user "John Doe" should be displayed
  #  And there should be 1 result for "John Doe"