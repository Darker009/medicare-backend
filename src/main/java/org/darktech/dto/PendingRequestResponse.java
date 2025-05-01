package org.darktech.dto;


public class PendingRequestResponse {

	private Long id;
	private String username;
	private String role;
	private String status;
	private DoctorDTO doctor;
	public PendingRequestResponse(Long id, String username, String role, String status, DoctorDTO doctor) {
		this.id = id;
		this.username = username;
		this.role = role;
		this.status = status;
		this.doctor = doctor;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public DoctorDTO getDoctor() {
		return doctor;
	}
	public void setDoctor(DoctorDTO doctor) {
		this.doctor = doctor;
	}
	
	
	
}
