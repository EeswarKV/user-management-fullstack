package com.example.usermanagement.service;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.usermanagement.exception.UserNotPresentException;
import com.example.usermanagement.model.User;
import com.example.usermanagement.repository.UserRepository;
import com.example.usermanagement.service.UserManagementService;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UserManagementServiceTest {

    @Autowired
    private UserManagementService userManagementService;

    @MockBean
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User(1L, "John", "Doe", "john@example.com", "Active", 1234567890, LocalDate.parse("1990-01-01"), "123 Main St");
    }

    @Test
    public void testGetAllUsers() {
        // Mocking repository response
        List<User> users = Arrays.asList(user);
        when(userRepository.findAll()).thenReturn(users);

        // Performing service method
        List<User> result = userManagementService.getAllUsers();

        // Assertions
        assertEquals(users.size(), result.size());
        assertEquals(users.get(0).getFirstName(), result.get(0).getFirstName());
        assertEquals(users.get(0).getLastName(), result.get(0).getLastName());
    }

    @Test
    public void testGetUserByID() throws UserNotPresentException {
        // Mocking repository response
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        // Performing service method
        User result = userManagementService.getUserByID(1L);

        // Assertions
        assertNotNull(result);
        assertEquals(user.getFirstName(), result.getFirstName());
        assertEquals(user.getLastName(), result.getLastName());
    }

    @Test
    public void testCreateUser() {
        // Mocking repository response
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Performing service method
        User result = userManagementService.createUser(user);

        // Assertions
        assertNotNull(result);
        assertEquals(user.getFirstName(), result.getFirstName());
        assertEquals(user.getLastName(), result.getLastName());
    }

    @Test
    public void testUpdateUser() throws UserNotPresentException {
        // Mocking repository response
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Performing service method
        User updatedUser = new User(1L, "John", "Doe", "john@example.com", "Active", 1234567890, LocalDate.parse("1990-01-01"), "456 Second St");
        User result = userManagementService.updateUser(1L, updatedUser);

        // Assertions
        assertNotNull(result);
        assertEquals(updatedUser.getAddress(), result.getAddress());
    }

    @Test
    public void testDeleteUser() throws UserNotPresentException {
        // Mocking repository response
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        // Performing service method
        userManagementService.deleteUser(1L);

        // Verify that delete method was called with the correct ID
        verify(userRepository, times(1)).deleteById(1L);
    }
}
