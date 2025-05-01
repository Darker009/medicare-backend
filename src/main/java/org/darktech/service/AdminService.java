package org.darktech.service;

import org.springframework.http.ResponseEntity;

public interface AdminService {
    ResponseEntity<?> approveUser(String role, Long id);
    ResponseEntity<?> getAllRequests();
    ResponseEntity<?> getProfile(Long id);
//    ResponseEntity<byte[]> getUserImage(Long userId);
}