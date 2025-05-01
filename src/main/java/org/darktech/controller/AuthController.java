package org.darktech.controller;

import java.io.IOException;

import org.darktech.dto.LoginRequest;
import org.darktech.dto.LoginResponse;
import org.darktech.dto.RegisterRequest;
import org.darktech.entity.User;
import org.darktech.service.AuthService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:5173", exposedHeaders = "Content-Disposition")
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
    
    @GetMapping("/image/{userId}")
    public ResponseEntity<byte[]> getUserProfileImage(@PathVariable Long userId) {
        User user = authService.getUserById(userId);
        if (user.getImageData() == null || user.getImageType() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(user.getImageType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + user.getImageName() + "\"")
                .body(user.getImageData());
    }
}
