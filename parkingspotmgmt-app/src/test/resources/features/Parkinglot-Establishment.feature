#Author: venkata vallabhaneni
Feature: As an administrator i want to create/establish  a new parking lot in a city named Bangalore in premises ITPB

  Scenario Outline: create a parking lot using appropriate name
    Given parking lot name <name>
    When I call the service create parking lot
    Then I should get response with HTTP status code <status>
    And the response should contain the <message>

    Examples:
      | name | status | message |
      | Lot1 | 200    | Lot1    |
      | Lot2 | 200    | Lot2    |
      | lot3 |  403   | Unauthorized|