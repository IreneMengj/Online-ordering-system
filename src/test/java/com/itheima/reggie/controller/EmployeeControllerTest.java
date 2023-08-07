package com.itheima.reggie.controller;

import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Employee;
import com.itheima.reggie.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class EmployeeControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private EmployeeController employeeController;
    @MockBean
    private EmployeeService employeeService;
    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }
    @Test
    public void testValidLogin() throws Exception {
        Employee emp = new Employee();
        emp.setStatus(1);
        emp.setPassword(DigestUtils.md5DigestAsHex("123".getBytes()));
        emp.setUsername("john_doe");
        when(employeeService.getOne(any())).thenReturn(emp);

        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/employee/login")
                .content("{\"username\":\"john_doe\",\"password\":\"123\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(1));
    }

    @Test
    public void testInvalidUsername() throws Exception {
        when(employeeService.getOne(any())).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/employee/login")
                .content("{\"username\":\"non_existing\",\"password\":\"password123\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{\"code\":0,\"msg\":\"username " +
                        "doesn't exist\",\"data\":null,\"map\":{}}"));
    }


}

@SpringBootTest
class EmployeeControllerIntegrationTest {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeController employeeController;
    @Test
    @Transactional
    public void testValidLogin() throws Exception {
        // Create the employee object with valid credentials in database
        Employee emp = new Employee();
        emp.setUsername("admin");
        emp.setPassword("123456");

        // Perform the HTTP request to the actual endpoint
        HttpServletRequest request = new MockHttpServletRequest(); // Assuming you have a MockHttpServletRequest class available
        R<Employee> result = employeeController.login(request, emp);

        // Assertions
        assertEquals(1, result.getCode());
        assertEquals("admin", result.getData().getUsername());
    }
}