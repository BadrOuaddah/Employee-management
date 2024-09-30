Feature: OAuth2 Token

  Scenario: Get token from Keycloak

    Given url tokenUrl
    And header Content-Type = 'application/x-www-form-urlencoded'
    And request { grant_type: 'password', client_id: 'employee-app', username: 'adminuser', password: 'password' }
    When method POST
    Then status 200
    And print response
    * def token = response.access_token
