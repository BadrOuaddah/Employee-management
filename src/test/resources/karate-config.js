function fun() {
    var keycloakHost = karate.env == 'docker' ? 'keycloak:8080' : 'localhost:9091';
    var config = {
        baseUrl: 'http://localhost:8082',
        tokenUrl: `http://${keycloakHost}/realms/SpringBootKeycloak/protocol/openid-connect/token`,
        clientId: 'employee-app',
        clientSecret: 'myClientSecret',
        users: {
            adminUser: { username: 'adminUser', password: 'password' },
            managerUser: { username: 'managerUser', password: 'password' },
            employeeUser: { username: 'employeeUser', password: 'password' }
        }
    };

    var result = karate.callSingle('classpath:karate/token.feature', config);
    config.authToken = result.authToken;

    karate.configure('headers', { Authorization: 'Bearer ' + config.authToken });

    return config;
}
