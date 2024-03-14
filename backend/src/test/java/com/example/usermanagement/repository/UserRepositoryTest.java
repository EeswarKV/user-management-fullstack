package com.example.usermanagement.repository;

import com.example.usermanagement.model.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import com.example.usermanagement.service.*;
import java.util.*;
class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindAll() {
        // Mock the repository response
        when(userRepository.findAll()).thenReturn(Collections.singletonList(new User()));
        // Perform the repository method
        List<User> users = userRepository.findAll();
        // Assert the result
        assertEquals(1, users.size());
    }

    
}
