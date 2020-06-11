Feature: AS wallet owner I WANT TO display my verified public bitcoin address SO THAT others can send bitcoin to my wallet

  Scenario: Looking at Bitcoin Address Visual
   // Given Server is Running at "192.168.56.1:8088"
    When The Page is Loaded
    Then I can see the Bitcoin Address

  Scenario: Checking for correct Bitcoin Address
   // Given Server is Running at "192.168.56.1:8088"
    When The Page is Loaded
    Then The following Bitcoin Address is visible "13uMuecDkSEps8kGhh1BpVdAHafsEQnqeY"