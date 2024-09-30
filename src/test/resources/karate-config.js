function fun() {
    var config = {
        baseUrl: 'http://localhost:8080',
        tokenUrl: 'http://localhost:9091/realms/SpringBootKeycloak/protocol/openid-connect/token'
    };

    var result = karate.callSingle('classpath:karate/token.feature', config);
    config.authToken = result.token;

    karate.configure('headers', { Authorization: 'Bearer ' + config.authToken });

    return config;
}
