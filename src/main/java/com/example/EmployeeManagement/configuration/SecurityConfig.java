package com.example.EmployeeManagement.configuration;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakLogoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@KeycloakConfiguration
public class SecurityConfig {

    private final KeycloakLogoutHandler keycloakLogoutHandler;

    public SecurityConfig(KeycloakLogoutHandler keycloakLogoutHandler) {
        this.keycloakLogoutHandler = keycloakLogoutHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/error", "/css/**", "/js/**").permitAll()
                        .requestMatchers("/users/**").hasRole("ADMIN")
                        .requestMatchers("/employees/**").hasAnyRole("ADMIN", "MANAGER")
                        .requestMatchers("/employees/view/**").hasRole("EMPLOYEE")
                        .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                        .anyRequest().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .jwkSetUri("http://localhost:8080/realms/master/protocol/openid-connect/certs")))
                .logout(logout -> logout
                        .addLogoutHandler(keycloakLogoutHandler)
                        .logoutSuccessUrl("/")
                        .permitAll());
        return http.build();
    }
}
