Feature: Login to WebReads Patron Management Page

  Scenario: User can login with valid credentials
    Given user is on the WebReads UAT Login page
    And the library id is set to "RJ1A - NLS"
    When user enters valid userName "RJ1A222222"
    And user enters valid password "12345678password"
    And user clicks "Log In" button
    And user clicks "Agree" button
    Then user gets redirected to "RJ1A - Patron Account"
    And user verifies the title of the page is "  WebReads Patrons"