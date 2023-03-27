@CEA10-301
Feature: As a user, I should be able to change profile info settings under the Profile module

  Background:
    Given User on the login page
    When  User enters correct "username" and "password"
    Then  Ceallo dashboard should be displayed
    And User clicks on "settings" link
    And User navigates to profile settings page

  @CEA10-292
    Scenario: Verify user can see following titles inside personal info under Profile Settings page;
  =>Full name/Email/Phone Number
    When User clicks on "settings" link
    And User navigates to profile settings page
    Then User can see Full name title
    And  User can see Email title
    And  User can see Phone number title

  @CEA10-302
    Scenario: Verify user can change "Full name" info under Profile Settings page
    When User navigates to Full Name inputbox
    And  Enters new "name" and "surname"
    Then Info should update to new "name" and "surname"

  @CEA10-303
    Scenario: Verify user can make "Phone number" info as private under Profile Settings page
    When User clicks on privacy link
    Then User can select private mode

  @CEA10-304
    Scenario: Verify user can see the current local time under the Locale dropdown
    When User checks time under Locale dropdown
    Then current local time is displayed correctly