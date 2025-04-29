package org.darktech.service.impl;

import org.darktech.entity.User;
import org.darktech.enums.UserStatus;
import org.darktech.repository.DoctorRepository;
import org.darktech.repository.UserRepository;
import org.darktech.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public ResponseEntity<?> approveUser(String role, Long id) {
		switch(role) {
		case "DOCTOR":
			
			return doctorRepository.findById(id).map(doctor ->{
				User user = doctor.getUser();
				user.setStatus(UserStatus.ACTIVE);
				doctor.setStatus(UserStatus.ACTIVE);
				doctor.setActive(true);
				userRepository.save(user);
				doctorRepository.save(doctor);
				return ResponseEntity.ok("Doctor approved successfully");
			}).orElse(ResponseEntity.badRequest().body("Doctor not found"));
		
		default:
			
			return ResponseEntity.badRequest().body("Invalid role");
		}
		
	}
}
