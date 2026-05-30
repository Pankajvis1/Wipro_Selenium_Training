Feature: Verify Login Functionality

  Scenario Outline: Verify login page
    Given the login page is open in the default browser
    When the user enters username "<username1>"
    And the user enters password "<password1>"
    And the user clicks the submit button with status "<Status>"
    Then verify login result "<Status>"

    Examples:
      | username1 | password1 | Status  |
      | username  | password  | success |
      | adjak     | password  | fail    |
      | username  | jkahjbka  | fail    |
      | kjdakhdae | jkahjbka  | fail    |