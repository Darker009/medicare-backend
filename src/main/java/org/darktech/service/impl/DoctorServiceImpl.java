package org.darktech.service.impl;


import org.darktech.dto.ProfileDTO;
import org.darktech.entity.User;
import org.darktech.enums.Role;
import org.darktech.repository.DoctorRepository;
import org.darktech.repository.UserRepository;
import org.darktech.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseEntity<?> getProfile(Long id) {
		return userRepository.findById(id).map(this::buildProfileResponse).orElse(ResponseEntity.notFound().build());

	}

	private ResponseEntity<?> buildProfileResponse(User user) {
	    if (!user.getRole().equals(Role.DOCTOR)) {
	        return ResponseEntity.badRequest().body("User is not a doctor");
	    }

	    ProfileDTO dto = ProfileDTO.builder()
	    	    .userId(user.getId())
	    	    .username(user.getUsername())
	    	    .role(user.getRole().toString())
	    	    .status(user.getStatus().toString())
	    	    .doctorId(user.getDoctor().getDoctorId())
	    	    .doctorName(user.getDoctor().getDoctorName())
	    	    .doctorSpecialization(user.getDoctor().getDoctorSpecialization())
	    	    .doctorContact(user.getDoctor().getDoctorContact())
	    	    .doctorExperience(user.getDoctor().getDoctorExperience())
	    	    .build1();

 return ResponseEntity.ok(dto);
	}

}
