package com.scm.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.scm.entities.User;
import com.scm.helpers.ResourceNotFoundException;
import com.scm.repositories.UserRepository;
import com.scm.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        // user id: have to generate
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);

        // password encode
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        //  set the default user role

        user.setRoleList(List.of("ROLE_USER"));

        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updatUser(User user) throws ResourceNotFoundException {

        User user2 = userRepo.findById(user.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found."));

        // update user2 from user

        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setProfilePic(user.getProfilePic());
        user2.setEnable(user.isEnabled());
        user2.setEmailVerified(user.getEmailVerified());
        user2.setPhoneVerified(user.getPhoneVerified());
        user2.setProviders(user.getProviders());
        user2.setProviderUserId(user.getProviderUserId());
        // save the user in db
        User save = userRepo.save(user2);
        return Optional.ofNullable(save);
    }

    @Override
    public void deleteUser(String id) throws ResourceNotFoundException {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found."));
        userRepo.delete(user);
    }

    @Override
    public Boolean isUserExist(String userId) {
        User user = userRepo.findById(userId).orElse(null);

        return user != null ? true : false;
    }

    @Override
    public Boolean isUserExistByEmail(String email) {
        User user = userRepo.findByEmail(email).orElse(null);
        return user != null ? true : false;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

}
