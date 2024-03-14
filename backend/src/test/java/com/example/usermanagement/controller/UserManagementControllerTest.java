package com.example.usermanagement.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
 import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
 import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.example.usermanagement.controller.UserManagementController;
import com.example.usermanagement.exception.UserNotPresentException;
import com.example.usermanagement.model.User;
import com.example.usermanagement.service.IUserManagementService;
import static org.hamcrest.CoreMatchers.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.any;
import  org.hamcrest.Matchers;


@WebMvcTest(UserManagementController.class)
public class UserManagementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IUserManagementService userManagementService;

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User(1L, "John", "Doe", "john@example.com", "Active", 1234567890, LocalDate.parse("1990-01-01"), "123 Main St");
    }

    @Test
    public void testGetAllUsers() throws Exception {
        // Mocking service response
        List<User> users = Arrays.asList(user);
        when(userManagementService.getAllUsers()).thenReturn(users);

        // Performing GET request
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[0].lastName").value("Doe"));
    }

    @Test
    public void testGetUserByID() throws Exception {
        // Mocking service response
        when(userManagementService.getUserByID(1L)).thenReturn(user);

        // Performing GET request
        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"));
    }

  @Test
public void testCreateUser() throws Exception {
    // Create a sample user object for mock service response
    User newUser = new User(1L, "John", "Doe", "john@example.com", "Active", 1234567890, LocalDate.parse("1990-01-01"), "123 Main St");

    // Mocking service response to return the newly created user
    when(userManagementService.createUser(any())).thenReturn(newUser);

    // Performing POST request
    mockMvc.perform(post("/api/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{ \"firstName\": \"John\", \"lastName\": \"Doe\", \"email\": \"john@example.com\", \"status\": \"Active\", \"phoneNumber\": 1234567890, \"birthDate\": \"1990-01-01\", \"address\": \"123 Main St\" }"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.firstName").value("John"))
            .andExpect(jsonPath("$.lastName").value("Doe"))
            .andExpect(jsonPath("$.email").value("john@example.com"))
            .andExpect(jsonPath("$.status").value("Active"));
}

   @Test
public void testUpdateUser() throws Exception {
    User user = new User(1L, "John", "Doe", "john@example.com", "Active", 1234567890, LocalDate.parse("1990-01-01"), "123 Main St");


    when(userManagementService.updateUser(eq(1L), any())).thenReturn(user);

    mockMvc.perform(put("/api/users/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{ \"firstName\": \"John\", \"lastName\": \"Doe\", \"email\": \"john@example.com\", \"status\": \"Active\", \"phoneNumber\": 1234567890, \"birthDate\": \"1990-01-01\", \"address\": \"123 Main St\" }"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.firstName").value("John"))
            .andExpect(jsonPath("$.lastName").value("Doe"))
            .andExpect(jsonPath("$.email").value("john@example.com"))
            .andExpect(jsonPath("$.status").value("Active"));
}

    @Test
    public void testDeleteUser() throws Exception {
        // Mocking service response
        doNothing().when(userManagementService).deleteUser(1L);

        // Performing DELETE request
        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Success"));
    }
}
