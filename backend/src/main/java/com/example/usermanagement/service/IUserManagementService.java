package com.example.usermanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.usermanagement.exception.UserNotPresentException;
import com.example.usermanagement.model.User;
@Service
public interface IUserManagementService {
    List<User> getAllUsers();
    User getUserByID(Long id) throws UserNotPresentException;
    User updateUser(Long id,User user) throws UserNotPresentException;
    void deleteUser(Long id) throws UserNotPresentException;
    User createUser(User user) ;
}
