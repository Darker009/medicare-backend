package org.darktech.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDTO {
	private Long userId;
	private String username;
	private String role;
	private String status;

	private Long adminId;
	private String adminName;
	private String adminContact;

	private Long doctorId;
	private String doctorName;
	private String doctorSpecialization;
	private String doctorContact;
	private Integer doctorExperience;

	public ProfileDTO() {
	}

	public ProfileDTO(Long userId, String username, String role, String status, Long adminId, String adminName,
			String adminContact) {
		this.userId = userId;
		this.username = username;
		this.role = role;
		this.status = status;
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminContact = adminContact;
	}

	public ProfileDTO(Long userId, String username, String role, String status, Long doctorId, String doctorName,
			String doctorSpecialization, String doctorContact, Integer doctorExperience) {
		this.userId = userId;
		this.username = username;
		this.role = role;
		this.status = status;
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorSpecialization = doctorSpecialization;
		this.doctorContact = doctorContact;
		this.doctorExperience = doctorExperience;
	}

	public static ProfileDTOBuilder builder() {
		return new ProfileDTOBuilder();
	}

	// Getters and Setters
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}

	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}

	public String getDoctorContact() {
		return doctorContact;
	}

	public void setDoctorContact(String doctorContact) {
		this.doctorContact = doctorContact;
	}

	public Integer getDoctorExperience() {
		return doctorExperience;
	}

	public void setDoctorExperience(Integer doctorExperience) {
		this.doctorExperience = doctorExperience;
	}

	public static class ProfileDTOBuilder {
	    private Long userId;
	    private String username;
	    private String role;
	    private String status;

	    private Long adminId;
	    private String adminName;
	    private String adminContact;

	    private Long doctorId;
	    private String doctorName;
	    private String doctorSpecialization;
	    private String doctorContact;
	    private Integer doctorExperience;

	    // Common fields
	    public ProfileDTOBuilder userId(Long userId) {
	        this.userId = userId;
	        return this;
	    }

	    public ProfileDTOBuilder username(String username) {
	        this.username = username;
	        return this;
	    }

	    public ProfileDTOBuilder role(String role) {
	        this.role = role;
	        return this;
	    }

	    public ProfileDTOBuilder status(String status) {
	        this.status = status;
	        return this;
	    }

	    // Admin-specific fields
	    public ProfileDTOBuilder adminId(Long adminId) {
	        this.adminId = adminId;
	        return this;
	    }

	    public ProfileDTOBuilder adminName(String adminName) {
	        this.adminName = adminName;
	        return this;
	    }

	    public ProfileDTOBuilder adminContact(String adminContact) {
	        this.adminContact = adminContact;
	        return this;
	    }

	    // Doctor-specific builder-style methods (FIXED)
	    public ProfileDTOBuilder doctorId(Long doctorId) {
	        this.doctorId = doctorId;
	        return this;
	    }

	    public ProfileDTOBuilder doctorName(String doctorName) {
	        this.doctorName = doctorName;
	        return this;
	    }

	    public ProfileDTOBuilder doctorSpecialization(String doctorSpecialization) {
	        this.doctorSpecialization = doctorSpecialization;
	        return this;
	    }

	    public ProfileDTOBuilder doctorContact(String doctorContact) {
	        this.doctorContact = doctorContact;
	        return this;
	    }

	    public ProfileDTOBuilder doctorExperience(Integer doctorExperience) {
	        this.doctorExperience = doctorExperience;
	        return this;
	    }

	    // Build methods for different roles
	    public ProfileDTO build() {
	        return new ProfileDTO(userId, username, role, status, adminId, adminName, adminContact);
	    }

	    public ProfileDTO build1() {
	        return new ProfileDTO(userId, username, role, status, doctorId, doctorName, doctorSpecialization, doctorContact, doctorExperience);
	    }
	}

}