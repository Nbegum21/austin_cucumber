@login_Test
Feature: Test login Functionalities

  Background:
    Given   a user is on the login page

  @positive_Test
  Scenario:  check login is successful with valid credentials
    When   user enters username "Nur begum" and password "12345"
    And  click on login button
    Then  user is navigated to home page

  @dataDriven_test @positive_test
    Scenario Outline: check login is successful with valid credentials for multiple users
      When   user enters username "<username>" and password "<password>"
      And  click on login button
      Then  user is navigated to home page
      Examples:
      |username|password|
      |Nur begum|12345  |
      |Anika    |12345  |
      |joly     |12345  |


  @dataDriven_test @positive_test
  Scenario:  check user is successful login using Data table s
    When   user click on login button upon entering credentials
    |username|password|
    |Nur Begum|12345  |
     Then user is navigated to home page

@negative_test
  Scenario:  check login is unsuccessful with invalid credentials
    When   user enters username "Nur begum" and password "3333"
    And  click on login button
    Then  user is failed to login



