package org.juannn.lockit.service;

import org.juannn.lockit.model.User;
import org.juannn.lockit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String saveUser(User user) {
        userRepository.save(user);
        return "User saved successfully." + user.getId();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        Optional<User> existingUser = userRepository.findById(user.getId());
        if (existingUser.isPresent()) {
            existingUser.get().setUsername(user.getUsername());
            existingUser.get().setEmail(user.getEmail());
            userRepository.save(existingUser.get());
            return existingUser.get();
        }
        return null;
    }

    public User deleteUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.delete(user);
            return user;
        }
        return null;
    }

}
