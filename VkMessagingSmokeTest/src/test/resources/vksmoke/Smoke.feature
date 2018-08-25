Feature: Smoke

  Scenario: Send message
  As a user I should be able to send and receive messages

    Given I've opened chat with User
    When I send a message to User
    Then the message should appear in my chat
    And User should receive the same message