package org.darktech.controller;

import org.darktech.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173", exposedHeaders = "Content-Disposition")
@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

	private final DoctorService doctorService;
	
	public DoctorController(DoctorService doctorService) {
		this.doctorService=doctorService;
	}
	
	@GetMapping("/profile/{id}")
	ResponseEntity<?> getProfile(@PathVariable Long id){
		
		return doctorService.getProfile(id);
	}
}
