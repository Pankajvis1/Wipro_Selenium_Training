Feature: Verify Registration Functionality

  Scenario Outline: Registration with valid credentials

    Given the registration page is open in the default browser
    When the user enters a valid first name <first_name> 
    And the user enters a valid last name <last_name>
    And the user enters a valid email address <email_address>
    And the user enters a valid telephone number <telephone_number>
    And the user enters a valid registration password <password>
    And the user confirms the registration password <confirm_password>
    And the user accepts the privacy policy
    And the user clicks the registration continue button
    Then the user should be registered successfully
    And the user should be redirected to the registration success page
    And the user searches for a product
    Then search results should be displayed
    
  Examples:
  |first_name|last_name|email_address|telephone_number|password|confirm_password|
  |pankaj|vishwakarma|pankaj@13248673gmail.com|973817871|test@12344|test@12344|