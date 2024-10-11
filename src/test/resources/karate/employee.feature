Feature: Employee management

  Background:
    * url baseUrl

  Scenario: Manager can access to manager list
    Given call read('token.feature@getToken')
    Given path "/managers"
    And header Authorization = 'Bearer ' + authToken
    When method GET
    Then status 200

  Scenario: Manager cannot access to user list
    Given call read('token.feature@getToken')
    Given path "/users"
    And header Authorization = 'Bearer ' + authToken
    When method GET
    Then status 403