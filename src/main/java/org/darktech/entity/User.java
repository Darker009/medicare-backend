package org.darktech.entity;

import jakarta.persistence.*;
import org.darktech.enums.Role;
import org.darktech.enums.UserStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true, length = 50)
	private String username;

	@Column(nullable = false, length = 100)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private UserStatus status;

	private String imageName;
	private String imageType;

	@Lob
	@JsonIgnore
	private byte[] imageData;

	// Role-specific mappings
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Admin admin;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Doctor doctor;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Reception reception;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Nurse nurse;

	private String profilePicUrl;

	private boolean profileUpdated = false;

	public User() {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public boolean isProfileUpdated() { return profileUpdated ; }
	public void setProfileUpdated(boolean profileUpdated) { this.profileUpdated = profileUpdated; }

	public String getProfilePicUrl() { return profilePicUrl; }
	public void setProfilePicUrl(String profilePicUrl) {
		if (profilePicUrl != null && !profilePicUrl.isBlank() &&
				!profilePicUrl.startsWith("http") && !profilePicUrl.startsWith("/")) {
			throw new IllegalArgumentException("Profile picture URL must be absolute or start with /");
		}
		this.profilePicUrl = profilePicUrl;
	}
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Reception getReception() {
		return reception;
	}

	public void setReception(Reception reception) {
		this.reception = reception;
	}

	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}
}