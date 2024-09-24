package com.example.EmployeeManagement.integrationTesting;

import com.example.EmployeeManagement.EmployeeManagementApplication;
import com.intuit.karate.junit5.Karate;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {EmployeeManagementApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class KarateRunnerTest {
    @Karate.Test
    Karate testAll() {
        return Karate.run("classpath:karate/employee.feature");
    }
}
