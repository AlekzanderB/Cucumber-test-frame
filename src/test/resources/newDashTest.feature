Feature: Admin order check
  As an admin,
  I want to check order for a customer
  so that I can filter order by customer
  so that I can filter by order ID
  so that I can review the selected order



  @regression
  Scenario: Select orders by customer nam
    Given the admin is on Login Page
    When he enters "admin" as username
    And he enters "parola123!" as password
    And he clicks over login button
    Then he has the Dashboard page open
    And he selects sales drop down menu
    And he selects orders option
    And he enters "Jonny Cash" as customer name
    And he uses filter button
    Then he has the orders list from "Jonny Cash"

  @regression
  Scenario: Select orders by customer nam
    Given the admin is on Login Page
    When he enters "admin" as username
    And he enters "parola123!" as password
    And he clicks over login button
    Then he has the Dashboard page open
    And he selects sales drop down menu
    And he selects orders option
    And he enters "1723" as customer order ID
    And he uses filter button
    Then he uses the view button

  @regression
  Scenario: Select orders by customer nam
    Given the admin is on Login Page
    When he enters "admin" as username
    And he enters "parola123!" as password
    And he clicks over login button
    Then he has the Dashboard page open
    And he selects sales drop down menu
    And he selects orders option
    And he enters "Pending" at order status drop down menu
    And he uses filter button
    Then he sees only pending orders selected


