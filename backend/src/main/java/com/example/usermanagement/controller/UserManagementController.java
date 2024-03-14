package com.example.usermanagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.usermanagement.exception.UserNotPresentException;
import com.example.usermanagement.model.User;

import com.example.usermanagement.service.IUserManagementService;

import java.util.List;
@RestController
@RequestMapping("/api")
public class UserManagementController {
    @Autowired
    private IUserManagementService userManagementService;

    @GetMapping(path = "/users",produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<User> getBooks(){
        List<User> users = userManagementService.getAllUsers();
        return users;
    }
    @GetMapping(path = "/users/{id}",produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity getUser(@PathVariable Long id) throws Exception{
        
            User user = userManagementService.getUserByID(id);
            return ResponseEntity.ok(user);
       
        
    }
    @PostMapping(path = "/users",produces = { MediaType.APPLICATION_JSON_VALUE })
    public User ceateUser(@RequestBody User user){
       User createdUser =  userManagementService.createUser(user);
        return  createdUser;

    } 
    @PutMapping(path = "/users/{id}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> updateUser(@PathVariable Long id,@RequestBody User user) throws Exception{
    
        return ResponseEntity.ok(userManagementService.updateUser(id,user));
    }
    @DeleteMapping(path="/users/{id}")
    public ResponseEntity deleteUserById(@PathVariable Long id)throws Exception{
        userManagementService.deleteUser(id);
        return  ResponseEntity.ok("Success");

    } 
}
