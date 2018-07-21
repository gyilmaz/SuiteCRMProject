Feature: SugarCRM menu options

	@tag 
  Scenario: Verify Collaboration menu options
    Given I logged into suiteCRM
    When I hover over the Collaboration menu
    Then following menu options should be visible for Collaboration:
      | Home      |
      | Emails    |
      | Documents |
      | Projects  |

  Scenario: Verify Support menu options
    Given I logged into suiteCRM
    When I hover over the Support menu
    Then following menu options should be visible for Support:
      | Home     |
      | Accounts |
      | Contacts |
      | Cases    |

  
  Scenario: Verify Sales menu options
    Given I logged into suiteCRM
    When I hover over the Sales menu
    Then following menu options should be visible for Sales:
      | Home     |
      | Accounts |
      | Contacts |
      | Opportunities|
      | Leads    |
      
    Scenario: Verify Marketing menu options
    Given I logged into suiteCRM
    When I hover over the Marketing menu
    Then following menu options should be visible for Marketing:
      | Home     |
      | Accounts |
      | Contacts |
      | Leads    |
      | Campaigns|
      | Targets |
      | Target Lists|
      
    Scenario: Verify Activities menu options
    Given I logged into suiteCRM
    When I hover over the Activities menu
    Then following menu options should be visible for Activities:
      | Home     |
      | Calendar |
      | Calls |
      | Meetings |
      | Emails    |
      | Tasks |
      | Notes |
    
