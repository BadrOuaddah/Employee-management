package com.example.EmployeeManagement.unitTesting;

import com.example.EmployeeManagement.controller.EmployeeController;
import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "adminUser", roles = {"admin"})
    public void viewEmployeeTest() throws Exception {
        long employeeId = 1L;
        Employee employee = new Employee();

        when(employeeService.getEmployeeForView(employeeId)).thenReturn(Optional.of(employee));
        ResponseEntity<Optional<Employee>> optionalResponseEntity = employeeController.viewEmployee(employeeId);
        Assertions.assertNotNull(optionalResponseEntity);

        employeeService.getEmployeeForView(employeeId);
        mockMvc.perform(get("/employees/view/{employeeId}", employeeId)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk());

    }

}
