package com.example.SpringBootWebDevelopment.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootWebDevelopment.entity.User;
import com.example.SpringBootWebDevelopment.exception.ResourceNotFoundException;
import com.example.SpringBootWebDevelopment.repository.UserRepository;

@Service
public class UserService {
    private final Map<Integer, User> userStore = new ConcurrentHashMap<>();
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return new ArrayList<>(userStore.values());
    }

    public User getUserById(int id) {
        if (!userStore.containsKey(id)) {
            throw new ResourceNotFoundException("User not found with ID " + id);
        }
        return userStore.get(id);
    }


    public void addUser(User user) {
        userRepository.save( user);
    }

	
}
