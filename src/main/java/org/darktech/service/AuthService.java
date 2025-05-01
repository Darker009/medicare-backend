package org.darktech.service;

import org.darktech.dto.*;
import org.darktech.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AuthService {
    ResponseEntity<?> register(RegisterRequest registerRequest, MultipartFile image) throws IOException;
    LoginResponse login(LoginRequest loginRequest);
	User getUserById(Long userId);
}