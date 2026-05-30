Feature: PHPTravels Automation Framework

  @Smoke @Regression
  Scenario Outline: Validate Login Functionality
    Given user launches browser
    When user enters "<username>" and "<password>"
    And clicks on login button
    Then validate login result

    Examples:
      | username            | password |
      | user@phptravels.com | demouser |
      | invalid@gmail.com   | invalid  |
      |                     | demouser |
      | user@phptravels.com |          |

  @Regression
  Scenario: Validate Login Functionality Using Excel
    Given user launches browser
    When user performs login using excel data
    Then excel login validation should complete

  @Regression
  Scenario: Validate User Registration
    Given user opens registration page
    When user enters all mandatory registration details
    Then registration should be successful

  @Smoke @Regression
  Scenario: Validate Hotel Search
    Given user is on PHPTravels home page
    When user searches hotel for destination "Dubai"
    Then hotel search results should be displayed

  @Regression
  Scenario: Validate Dynamic Hotel Prices
    Given user is on PHPTravels home page
    When user searches hotel for destination "Dubai"
    Then validate hotel prices

  @Smoke @Regression
  Scenario: Validate Complete Booking Workflow
    Given user is logged into PHPTravels
    When user completes hotel booking flow
    Then booking confirmation message should be displayed

  @Regression
  Scenario: Validate Dynamic Booking Table
    Given user is on PHPTravels home page
    Then validate booking table dynamically
