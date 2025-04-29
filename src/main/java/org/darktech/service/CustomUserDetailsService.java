package org.darktech.service;

import java.util.List;

import org.darktech.dto.UserResponseDTO;
import org.darktech.entity.User;
import org.darktech.enums.UserStatus;
import org.darktech.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

 
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        System.out.println("Found user: " + user.getUsername() + ", Status: " + user.getStatus());

        // Prevent login if user is not ACTIVE
        if (user.getStatus() != UserStatus.ACTIVE) {
            throw new RuntimeException("User is not yet approved by admin.");
        }

        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            List.of(new SimpleGrantedAuthority(user.getRole().name()))
        );
    }

    // Additional method to provide the UserResponseDTO if needed
    public UserResponseDTO getUserResponseDTO(String username) {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Return a UserResponseDTO with userId, email, and role
        return new UserResponseDTO(
            user.getId(),
            user.getUsername(),
            user.getRole().name()  // Assuming role is an enum, use .name() to get the string representation
        );
    }
}
