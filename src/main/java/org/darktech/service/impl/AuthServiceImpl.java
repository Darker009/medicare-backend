package org.darktech.service.impl;

import org.darktech.config.JwtUtil;
import org.darktech.dto.ApiResponse;
import org.darktech.dto.LoginRequest;
import org.darktech.dto.LoginResponse;
import org.darktech.dto.RegisterRequest;
import org.darktech.dto.UserResponseDTO;
import org.darktech.exception.*;
import org.darktech.entity.*;
import org.darktech.enums.Role;
import org.darktech.enums.Shift;
import org.darktech.enums.UserStatus;
import org.darktech.repository.*;
import org.darktech.service.AuthService;
import org.darktech.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired private UserRepository userRepository;
    @Autowired private AdminRepository adminRepository;
    @Autowired private DoctorRepository doctorRepository;
    @Autowired private NurseRepository nurseRepository;
    @Autowired private ReceptionRepository receptionRepository;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private JwtUtil jwtUtil;
    @Autowired private CustomUserDetailsService customUserDetailsService;

    @Override
    public ResponseEntity<?> register(RegisterRequest registerRequest, MultipartFile image) throws RuntimeException {
        String email = registerRequest.getUsername();
        String password = registerRequest.getPassword();
        String rawRole = registerRequest.getRole();
        String name = registerRequest.getName();
        String contact = registerRequest.getContact();

        if (userRepository.existsByUsername(email)) {
            return ResponseEntity.badRequest().body("Email already exists");
        }

        Role role = null;
        if("admin@gmail.com".equalsIgnoreCase(email)) {
            role = Role.ADMIN;
        } else {
            if(rawRole == null || rawRole.isBlank()) {
                return ResponseEntity
                        .badRequest()
                        .body("Role must be provided for every users.");
            }
            try {
                role = Role.valueOf(rawRole);
            } catch (IllegalArgumentException e){
                return ResponseEntity
                        .badRequest()
                        .body("Invalid role specified: "+ rawRole);
            }
        }

        if (role == Role.ADMIN && !email.equals("admin@gmail.com")) {
            return ResponseEntity.badRequest().body("Only predefined admin email can register as ADMIN");
        }

        User user = new User();
        user.setUsername(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        user.setStatus(role == Role.ADMIN ? UserStatus.ACTIVE : UserStatus.PENDING);

        if (image != null && !image.isEmpty()) {
            if (!image.getContentType().startsWith("image/")) {
                return ResponseEntity.badRequest().body("Only image files are allowed");
            }
            
            try {
                user.setImageName(image.getOriginalFilename());
                user.setImageType(image.getContentType());
                user.setImageData(image.getBytes());
                
                user.setProfilePicUrl("/api/users/" + user.getId() + "/image");
            } catch (Exception e) {
                throw new InvalidImageException("Invalid image file");
            }
        }

        // Save the user WITH image data
        user = userRepository.save(user);

        switch (role) {
            case ADMIN:
                Admin admin = new Admin();
                admin.setUser(user);
                admin.setAdminName(name);
                admin.setAdminContact(contact);
                adminRepository.save(admin);
                break;

            case DOCTOR:
                if (registerRequest.getSpecialization() == null || registerRequest.getSpecialization().isEmpty()) {
                    return ResponseEntity.badRequest().body("Specialization is required for doctors");
                }
                if (registerRequest.getExperience() == null) {
                    return ResponseEntity.badRequest().body("Experience is required for doctors");
                }

                Doctor doctor = new Doctor();
                doctor.setUser(user);
                doctor.setDoctorName(name);
                doctor.setDoctorContact(contact);
                doctor.setDoctorSpecialization(registerRequest.getSpecialization().trim());
                doctor.setDoctorExperience(registerRequest.getExperience());
                doctor.setStatus(UserStatus.PENDING);
                doctor.setActive(false);

                Optional<Admin> adminForDoctor = adminRepository.findFirstByOrderByAdminIdAsc();
                if (adminForDoctor.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("System configuration error: No admin available to assign doctor");
                }
                doctor.setAdmin(adminForDoctor.get());

                doctorRepository.save(doctor);
                break;

            case NURSE:
                if (registerRequest.getShift() == null || registerRequest.getShift().trim().isEmpty()) {
                    return ResponseEntity.badRequest().body("Shift is required for nurses");
                }

                Nurse nurse = new Nurse();
                nurse.setUser(user);
                nurse.setNurseName(name);
                nurse.setNurseContact(contact);
                
                try {
                    nurse.setNurseShift(Shift.valueOf(registerRequest.getShift().trim().toUpperCase()));
                } catch (IllegalArgumentException e) {
                    return ResponseEntity.badRequest().body("Invalid shift specified for nurse");
                }
                
                nurse.setActive(true);
                nurseRepository.save(nurse);
                break;

            case RECEPTIONIST:
                Reception reception = new Reception();
                reception.setUser(user);
                reception.setReceptionName(name);
                reception.setReceptionContact(contact);
                reception.setStatus("PENDING");
                reception.setActive(false);
                receptionRepository.save(reception);
                break;

            default:
                return ResponseEntity.badRequest().body("Unsupported role");
        }

        return ResponseEntity.ok(new ApiResponse(true, "User registered successfully. " + 
            (role != Role.ADMIN ? "Waiting for admin approval." : "")));
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            var userDetails = customUserDetailsService.loadUserByUsername(loginRequest.getUsername());

            String jwt = jwtUtil.generateToken(userDetails);

            User user = userRepository.findByUsername(loginRequest.getUsername())
            	    .orElseThrow(() -> new RuntimeException("User not found with username: " + loginRequest.getUsername()));

            UserResponseDTO userDTO = new UserResponseDTO(
                    user.getId(),
                    user.getUsername(),
                    user.getRole().name()  
                    );

            return new LoginResponse(jwt, userDTO);
        } catch (Exception ex) {
            throw new BadCredentialsException("Invalid username or password");
        }

    }

	@Override
	public User getUserById(Long userId) {
    	System.out.println(userId);
		return userRepository.findById(userId).orElseThrow(() ->  new UserNotFoundException("No User Found with ID: " + userId));
	}
}
