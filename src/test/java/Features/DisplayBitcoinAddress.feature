Feature: AS wallet owner
  I WANT TO display my verified public bitcoin address
  SO THAT others can send bitcoin to my wallet

  #BACKGROUND IS: Repeating detail context to all the following scenarios
  Background:
    Given ServerX is Running
    And The Page is Loaded

  Scenario: Looking at Bitcoin Address Visual
    When The Header is Loaded
    Then The Header is visible

  Scenario: Checking for correct Bitcoin Address
    When I read the Header content
    Then The following Bitcoin Address is visible "13uMuecDkSEps8kGhh1BpVdAHafsEQnqeY"