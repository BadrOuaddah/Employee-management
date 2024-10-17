package com.example.EmployeeManagement.integrationTesting;

import com.example.EmployeeManagement.EmployeeManagementApplication;
import com.intuit.karate.junit5.Karate;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {EmployeeManagementApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ImportAutoConfiguration(exclude = {SecurityAutoConfiguration.class, OAuth2ClientAutoConfiguration.class})
public class KarateRunnerTest {
    @Karate.Test
    Karate testAll() {
        return Karate.run("classpath:karate/token.feature", "classpath:karate/employee.feature").relativeTo(getClass());
    }
}
