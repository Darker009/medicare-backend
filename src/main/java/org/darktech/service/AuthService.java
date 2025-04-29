package org.darktech.service;


import java.io.IOException;

import org.darktech.dto.LoginRequest;
import org.darktech.dto.LoginResponse;
import org.darktech.dto.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);

	ResponseEntity<?> register(RegisterRequest registerRequest, MultipartFile image) throws IOException;
}
