package org.darktech.controller;

import java.io.IOException;

import org.darktech.dto.LoginRequest;
import org.darktech.dto.LoginResponse;
import org.darktech.dto.RegisterRequest;
import org.darktech.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@ModelAttribute RegisterRequest registerRequest,
                                      @RequestParam(required = false) MultipartFile image) throws IOException {
        return authService.register(registerRequest, image);
    }
}
