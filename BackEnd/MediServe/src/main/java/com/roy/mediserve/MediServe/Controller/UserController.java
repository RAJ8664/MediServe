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
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        User user = userRepository.findById(userId).orElse(null);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /* Create a new User */
    @RequestMapping(method = RequestMethod.POST, path = "/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    /* Get userAddress by userId */
    @RequestMapping(method = RequestMethod.GET, path = "/users/userAddress/{userId}")
    public ResponseEntity<String> getUserAddressById(@PathVariable String userId) {
        if (!userRepository.existsById(userId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User user = userRepository.findById(userId).orElse(null);
        return new ResponseEntity<>(user.getUserAddress(), HttpStatus.OK);
    }        

    /* Get userImageUrl by userId */
    @RequestMapping(method = RequestMethod.GET, path = "/users/userImageUrl/{userId}")
    public ResponseEntity<String> getUserImageUrlById(@PathVariable String userId) {
        if (!userRepository.existsById(userId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User user = userRepository.findById(userId).orElse(null);
        return new ResponseEntity<>(user.getUserImageUrl(), HttpStatus.OK);
    }
    /* Get userName by userId */
    @RequestMapping(method = RequestMethod.GET, path = "/users/userName/{userId}")
    public ResponseEntity<String> getUserNameById(@PathVariable String userId) {
        if (!userRepository.existsById(userId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User user = userRepository.findById(userId).orElse(null);
        return new ResponseEntity<>(user.getUserName(), HttpStatus.OK);
    } 
    
    /* Delete a User by userId */
    @RequestMapping(method = RequestMethod.DELETE, path = "/users/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable String userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userRepository.delete(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /* Update a User by userId */
    @RequestMapping(method = RequestMethod.PUT, path = "/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User user) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingUser.setUserName(user.getUserName());
        existingUser.setUserPassword(user.getUserPassword());
        existingUser.setUserImageUrl(user.getUserImageUrl());
        User updatedUser = userRepository.save(existingUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    /* Update userPassword by userId */
    @RequestMapping(method = RequestMethod.PUT, path = "/users/password/{userId}")
    public ResponseEntity<User> updateUserPassword(@PathVariable String userId, @RequestBody User user) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingUser.setUserPassword(user.getUserPassword());
        User updatedUser = userRepository.save(existingUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    /* Update useImage by userId */
    @RequestMapping(method = RequestMethod.PUT, path = "/users/imageUrl/{userId}")
    public ResponseEntity<User> updateUserImage(@PathVariable String userId, @RequestBody User user) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingUser.setUserImageUrl(user.getUserImageUrl());
        User updatedUser = userRepository.save(existingUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    /* Update userName by userId */
    @RequestMapping(method = RequestMethod.PUT, path = "/users/userName/{userId}")
    public ResponseEntity<User> updateUserName(@PathVariable String userId, @RequestBody User user) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingUser.setUserName(user.getUserName());
        User updatedUser = userRepository.save(existingUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    /* Update userAddress by userId */
    @RequestMapping(method = RequestMethod.PUT, path = "/users/userAddress/{userId}")
    public ResponseEntity<User> updateUserAddress(@PathVariable String userId, @RequestBody User user) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingUser.setUserAddress(user.getUserAddress());
        User updatedUser = userRepository.save(existingUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
