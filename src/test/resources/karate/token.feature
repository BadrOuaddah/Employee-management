Feature: OAuth2 Token from Keycloak

  Background:
    * url tokenUrl
    * def clientId = clientId
    * def password = 'password'
    * def clientSecret = clientSecret
    * def adminUser = users.adminUser
    * def managerUser = users.managerUser
    * def employeeUser = users.employeeUser

  Scenario Outline: Import token for <role> user
    Given path ''
    And form field grant_type = password
    And form field client_id = clientId`
    And form field client_secret = clientSecret
    And form field username = '<username>'
    And form field password = '<password>'
    When method POST
    Then status 200
    And match response contains { access_token: '#notnull' }
    And def authToken = response.access_token
    * print '*** Authorization token for <role> *** : ', authToken

    Examples:
      | role     | username     | password |
      | admin    | adminUser    | password |
      | manager  | managerUser  | password |
      | employee | employeeUser | password |
