package com.roy.mediserve.MediServe.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.roy.mediserve.MediServe.Model.User;
import com.roy.mediserve.MediServe.Repository.UserRepository;

@RestController
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    /* Get all the Users */
    @RequestMapping(method = RequestMethod.GET, path = "/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /* Get User by ID */    
    @RequestMapping(method = RequestMethod.GET, path = "/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /* Create a new User */
    @RequestMapping(method = RequestMethod.POST, path = "/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    /* Delete a User by userId */
    @RequestMapping(method = RequestMethod.DELETE, path = "/users/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userRepository.delete(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /* Update a User by userId */
    @RequestMapping(method = RequestMethod.PUT, path = "/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingUser.setUserName(user.getUserName());
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());
        existingUser.setImageUrl(user.getImageUrl());
        User updatedUser = userRepository.save(existingUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    /* Update userPassword by userId */
    @RequestMapping(method = RequestMethod.PUT, path = "/users/password/{userId}")
    public ResponseEntity<User> updateUserPassword(@PathVariable Long userId, @RequestBody User user) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingUser.setPassword(user.getPassword());
        User updatedUser = userRepository.save(existingUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    /* Update userImage by userId */
    @RequestMapping(method = RequestMethod.PUT, path = "/users/imageUrl/{userId}")
    public ResponseEntity<User> updateUserImage(@PathVariable Long userId, @RequestBody User user) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingUser.setImageUrl(user.getImageUrl());
        User updatedUser = userRepository.save(existingUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    /* Update userRole by userId */
    @RequestMapping(method = RequestMethod.PUT, path = "/users/role/{userId}")
    public ResponseEntity<User> updateUserRole(@PathVariable Long userId, @RequestBody User user) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingUser.setRole(user.getRole());
        User updatedUser = userRepository.save(existingUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    /* Update userName by userId */
    @RequestMapping(method = RequestMethod.PUT, path = "/users/userName/{userId}")
    public ResponseEntity<User> updateUserName(@PathVariable Long userId, @RequestBody User user) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingUser.setUserName(user.getUserName());
        User updatedUser = userRepository.save(existingUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
