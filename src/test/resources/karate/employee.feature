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

  Scenario: Create new employee as manager user
    Given call read('token.feature@getToken')
    Given path "/employees"
    And header Authorization = 'Bearer ' + authToken
    And header Accept = 'application/json'
    And request {"firstName": "#(firstName)", "lastName": "#(lastName)", "email": "#(email)", "position": "#(position)", "department": "#(department)"}
    When method POST
    Then status 201

  Scenario: Delete employee
    Given call read('token.feature@getToken')
    Given path "/employees"
    And header Authorization = 'Bearer ' + authToken
    And header Accept = 'application/json'
    And request {"firstName": "#(firstName)", "lastName": "#(lastName)", "email": "#(email)", "position": "#(position)", "department": "#(department)"}
    When method POST
    Then status 201
    * def employeeId = $.id
    Given path "/employees/" + employeeId
    And header Accept = 'application/json'
    When method DELETE
    Then status 200