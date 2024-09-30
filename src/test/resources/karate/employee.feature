Feature: Employees API Test

  Scenario: Get All Employees
    Given url karate.get('baseUrl') + '/employees'
    When method GET
    Then status 200
    And match response contains { firstName: '#string', lastName: '#string' }

  Scenario: Get Specific Employee by ID
    Given url karate.get('baseUrl') + '/employees/1'
    When method GET
    Then status 200
    And match response contains { id: 1, firstName: '#string', lastName: '#string' }
