package org.darktech.service;

import org.springframework.http.ResponseEntity;

public interface DoctorService {
    ResponseEntity<?> getProfile(Long id);

	
}
