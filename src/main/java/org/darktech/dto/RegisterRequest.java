package org.darktech.dto;

import jakarta.validation.constraints.*;

public class RegisterRequest {
    @NotBlank(message = "Username cannot be blank")
    @Email(message = "Username must be a valid email address")
    private String username;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @NotBlank(message = "Role cannot be blank")
    private String role;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Contact information cannot be blank")
    @Pattern(regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$", 
             message = "Invalid contact number format")
    private String contact;

    private String specialization; 

    @Min(value = 0, message = "Experience cannot be negative")
    @Max(value = 100, message = "Experience cannot exceed 100 years")
    private Integer experience; 

    private String shift; 

    public RegisterRequest() {
    }

    public RegisterRequest(String username, String password, String role, String name,
                          String contact, String specialization, Integer experience, String shift) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.contact = contact;
        this.specialization = specialization;
        this.experience = experience;
        this.shift = shift;
    }

    
	public RegisterRequest(String username, String password, String name, String contact) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.contact = contact;

	}
    
    
    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getSpecialization() {
        return specialization;
    }

    public Integer getExperience() {
        return experience;
    }

    public String getShift() {
        return shift;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public void setShift(String shift) {
        this.shift = shift;
    } 
   

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experience=" + experience +
                ", shift='" + shift + '\'' +
                '}';
    }
}