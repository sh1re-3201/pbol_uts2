package com.sh1re.goldenbay.service;

import com.sh1re.goldenbay.dto.UserDTO;
import com.sh1re.goldenbay.model.User;
import com.sh1re.goldenbay.model.Role;
import com.sh1re.goldenbay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create a new user
    public UserDTO createUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        user = userRepository.save(user);
        return convertToDTO(user);
    }

    // Get all users
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get user by ID
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return convertToDTO(user);
    }

    // Update user
    public UserDTO updateUser(Long id, UserDTO userDTO) {
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

}
