Feature:  Login with correct credentials

  Acceptance Criteria:

  User can see at least following titles inside personal info under Profile Settings page;         =>Full name/Email/Phone Number
  User can change "Full name" info under Profile Settings page
  User can make "Phone number" info as private under Profile Settings page
  User can see the current local time under the Local dropdown
@login
  Scenario: As a user, I should be able to change profile info settings under the Profile module
    Given User on the login page
    When  User enters correct username and password
    Then  Ceallo dashboard should be displayed