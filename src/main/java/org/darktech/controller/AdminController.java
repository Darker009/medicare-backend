package org.darktech.controller;

import org.darktech.service.AdminService;  
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173", exposedHeaders = "Content-Disposition")
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    
    private final AdminService adminService;
    
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    
    @PostMapping("/approve/{role}/{id}")
    public ResponseEntity<?> approveUser(@PathVariable String role, @PathVariable Long id) {
        return adminService.approveUser(role, id);
    }
    
    @GetMapping("/fetch-all/requests")
    public ResponseEntity<?> getAllRequests() {
        return adminService.getAllRequests();
    }
    
    @GetMapping("/profile/{userId}")
    public ResponseEntity<?> getProfile(@PathVariable Long userId) {
        return adminService.getProfile(userId);
    }
    
   
}