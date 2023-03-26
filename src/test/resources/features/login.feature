Feature:  Logging in to Ceallo dashboard and navigating to the profile settings

    @CEA10-291 @login
    Scenario: User logging in with correct credentials
        Given User on the login page
        When  User enters correct "username" and "password"
        Then  Ceallo dashboard should be displayed
        And User clicks on "settings" link
        And User navigates to profile settings page
