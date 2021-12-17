Feature: Mortgage Calculator

 @CalculatorApr
  Scenario: Calculate Real Apr Rate
   Given user is in mortgage calculator home page
    And user navigate to Real Apr page
    When user click on login button upon entering the date
    |HomePrice|DownPayment|Interest Rate|
    |200000   |15000      |3            |
    Then the real apr rate is "3.130%"