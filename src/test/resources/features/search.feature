Feature: Search on the booking.com

  Scenario: Search by city criteria
    Given User is looking for hotels like "Gomel"
    When User does search
    Then Hotel "Park Hotel Zamkovy" should be on the first page
    And Rating of the hotel is "9.3"

  Scenario: Search by city criteria
    Given User is looking for hotels like "Brest"
    When User does search
    Then Hotel "Hermitage Hotel" should be on the first page
    And Rating of the hotel is "9.4"