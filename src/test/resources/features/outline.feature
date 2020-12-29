Feature: Search on the booking.com

  Scenario Outline: Search by city criteria
    Given User is looking for hotels like <location>
    When User does search
    Then Hotel <hotel> should be on the first page
    And Rating of the hotel is <rating>
    Examples:
      | location | hotel                | rating |
      | "Gomel"  | "Park Hotel Zamkovy" | "9.3"  |
      | "Brest"  | "Hermitage Hotel"    | "9.3"  |