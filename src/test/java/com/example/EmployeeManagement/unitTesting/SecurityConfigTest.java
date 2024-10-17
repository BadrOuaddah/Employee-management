package com.example.EmployeeManagement.unitTesting;

import com.example.EmployeeManagement.configuration.JwtConverter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ImportAutoConfiguration(exclude = {SecurityAutoConfiguration.class, OAuth2ClientAutoConfiguration.class})
public class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JwtConverter jwtConverter;

    @Test
    public void accessSwaggerUITest() throws Exception {
        mockMvc.perform(get("/swagger-ui/index.html"))
                .andExpect(status().isOk());
    }

    @Test
    public void accessApiDocsTest() throws Exception {
        mockMvc.perform(get("/v3/api-docs"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "adminUser", roles = {"admin"})
    public void adminRoleAccessTest() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "managerUser", roles = {"manager"})
    public void managerRoleAccessTest() throws Exception {
        mockMvc.perform(get("/managers"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "employeeUser", roles = {"employee"})
    public void employeeCanNotAccessTest() throws Exception {
        mockMvc.perform(get("/managers"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "unauthorizedUser", roles = {"employee"})
    public void unauthorizedAccessTest() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().isForbidden());
    }
}
