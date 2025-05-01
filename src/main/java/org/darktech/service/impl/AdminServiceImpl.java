package org.darktech.service.impl;

import org.darktech.dto.*;
import org.darktech.entity.*;
import org.darktech.enums.Role;
import org.darktech.enums.UserStatus;
import org.darktech.repository.*;
import org.darktech.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<?> approveUser(String role, Long id) {
        switch (role.toUpperCase()) {
            case "DOCTOR":
                return approveDoctor(id);
            default:
                return ResponseEntity.badRequest().body("Invalid role");
        }
    }

    @Override
    public ResponseEntity<?> getAllRequests() {
        List<User> pendingUsers = userRepository.findByStatus(UserStatus.PENDING);
        
        List<PendingRequestResponse> response = pendingUsers.stream()
            .map(this::convertToPendingRequestResponse)
            .collect(Collectors.toList());
            
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<?> getProfile(Long id) {
        return userRepository.findById(id)
            .map(this::buildProfileResponse)
            .orElse(ResponseEntity.notFound().build());
    }



    private ResponseEntity<?> approveDoctor(Long id) {
        return userRepository.findById(id)
            .map(user -> {
                Doctor doctor = user.getDoctor(); 
                if (doctor == null) {
                    return ResponseEntity.badRequest().body("Doctor not found");
                }
                
                user.setStatus(UserStatus.ACTIVE);
                doctor.setStatus(UserStatus.ACTIVE);
                doctor.setActive(true);
                
                userRepository.save(user);
                doctorRepository.save(doctor);
                
                return ResponseEntity.ok("Doctor approved successfully");
            })
            .orElse(ResponseEntity.badRequest().body("User not found"));
    }

    private PendingRequestResponse convertToPendingRequestResponse(User user) {
        DoctorDTO doctorDTO = user.getDoctor() != null ? 
            new DoctorDTO(
                user.getDoctor().getDoctorId(),
                user.getDoctor().getDoctorName(),
                user.getDoctor().getDoctorSpecialization(),
                user.getDoctor().getDoctorContact(),
                user.getDoctor().getDoctorExperience()
            ) : null;

        return new PendingRequestResponse(
            user.getId(),
            user.getUsername(),
            user.getRole().toString(),
            user.getStatus().toString(),
            doctorDTO
        );
    }

    private ResponseEntity<?> buildProfileResponse(User user) {
        if (!user.getRole().equals(Role.ADMIN)) {
            return ResponseEntity.badRequest().body("User is not an admin");
        }

        ProfileDTO dto = ProfileDTO.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .role(user.getRole().toString())
                .status(user.getStatus().toString())
                .adminId(user.getAdmin() != null ? user.getAdmin().getAdminId() : null)
                .adminName(user.getAdmin() != null ? user.getAdmin().getAdminName() : null)
                .adminContact(user.getAdmin() != null ? user.getAdmin().getAdminContact() : null)
                .build();

                return ResponseEntity.ok(dto);
    }

}