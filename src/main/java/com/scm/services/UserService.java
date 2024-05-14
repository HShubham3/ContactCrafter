package com.scm.services;

import java.util.List;
import java.util.Optional;

import com.scm.entities.User;
import com.scm.helpers.ResourceNotFoundException;

public interface UserService {

    User saveUser(User user);

    Optional<User> getUserById(String id);

    Optional<User> updatUser(User user) throws ResourceNotFoundException;

    void deleteUser(String id) throws ResourceNotFoundException;

    Boolean isUserExist(String userId);

    Boolean isUserExistByEmail(String email);

    List<User> getAllUsers();

    // add more methods here related user service

}
