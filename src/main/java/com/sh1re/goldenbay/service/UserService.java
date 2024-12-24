package com.sh1re.goldenbay.service;

import com.sh1re.goldenbay.config.SecurityConfig;
import com.sh1re.goldenbay.dto.UserDTO;
import com.sh1re.goldenbay.model.User;
import com.sh1re.goldenbay.model.Role;
import com.sh1re.goldenbay.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    private SecurityConfig securityConfig;

    // Create a new user
    public UserDTO createUser(UserDTO userDTO) {
        logger.info("Creating a new user with username: {}", userDTO.getUsername());
        User user = convertToEntity(userDTO);
        user = userRepository.save(user);
        return convertToDTO(user);
    }

    // Get all users
    public List<UserDTO> getAllUsers() {
        logger.info("Fetching all users");
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get user by ID
    public UserDTO getUserById(Long id) {
//        logger.info("Fetching user with ID: {}", id);
        System.out.println("===================FETCHING USER WITH ID:" + id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return convertToDTO(user);
    }

    // Update user
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        logger.info("Updating user with ID: {}", id);
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setUsername(userDTO.getUsername());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setRole(Role.valueOf(userDTO.getRole()));
        User updatedUser = userRepository.save(existingUser);
        return convertToDTO(updatedUser);
    }

    // Delete user
    public void deleteUser(Long id) {
        logger.info("Deleting user with ID: {}", id);
        userRepository.deleteById(id);
    }

    // Convert DTO to Entity
    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());

        // Convert String to Role Enum
        if (userDTO.getRole() != null) {
            try {
                user.setRole(Role.valueOf(userDTO.getRole().toUpperCase()));
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Invalid role: " + userDTO.getRole());
            }
        }

        return user;
    }

    // Convert Entity to DTO
    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());

        // Convert Role Enum to String
        if (user.getRole() != null) {
            userDTO.setRole(user.getRole().name());
        }

        return userDTO;
    }

    @PostConstruct
    public void init() {
        try {
            System.out.println("Initializing users...");
            if (userRepository.findByUsername("admin").isEmpty()) {
                userRepository.save(new User("admin", "admin", Role.ADMIN, "admin@gmail.com", LocalDateTime.now()));
                System.out.println("Admin user created.");
            }
            if (userRepository.findByUsername("user").isEmpty()) {
                userRepository.save(new User("user","password", Role.USER, "user@gmail.com", LocalDateTime.now()));
                System.out.println("Regular user created.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error during UserService initialization", e);
        }
    }


}