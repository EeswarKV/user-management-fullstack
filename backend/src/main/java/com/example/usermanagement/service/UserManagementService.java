package com.example.usermanagement.service;

import com.example.usermanagement.exception.UserNotPresentException;
import com.example.usermanagement.model.User;
import com.example.usermanagement.repository.UserRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserManagementService implements IUserManagementService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByID(Long id) throws UserNotPresentException {

        return this.getUserById(id);
    }

    @Override
    public User createUser(User user) {
        User createdUser = userRepository.save(user);
        return createdUser;
    }

    @Override
    public User updateUser(Long id, User user) throws UserNotPresentException {
        User userToBeUpdated = getUserById(id);
        if (user.getFirstName() != null)
            userToBeUpdated.setFirstName(user.getFirstName());
        if (user.getLastName() != null)
            userToBeUpdated.setLastName(user.getLastName());
        if (user.getAddress() != null)
            userToBeUpdated.setAddress(user.getAddress());
        if (user.getBirthDate() != null)
            userToBeUpdated.setBirthDate(user.getBirthDate());
        if (user.getEmail() != null)
            userToBeUpdated.setEmail(user.getEmail());
        if (user.getPhoneNumber() != 0)
            userToBeUpdated.setPhoneNumber(user.getPhoneNumber());
        if (user.getStatus() != null)
            userToBeUpdated.setStatus(user.getStatus());

        return userRepository.save(userToBeUpdated);
    }

    @Override
    public void deleteUser(Long id) throws UserNotPresentException {
        userRepository.delete(getUserById(id));

    }

    private User getUserById(Long id) throws UserNotPresentException {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotPresentException();
        }
        return user.get();
    }

}