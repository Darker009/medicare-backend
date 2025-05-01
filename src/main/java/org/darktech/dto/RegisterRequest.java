package org.darktech.dto;

import jakarta.validation.constraints.*;

public class RegisterRequest {
    @Email(message = "Username must be a valid email address")
    private String username;

    private String password;

    private String role;

    private String name;

    private String contact;

    private String specialization; 

    private Integer experience; 

    private String shift; 

    // Default constructor
    public RegisterRequest() {
    }

    // General constructor (keep existing)
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

    // Keep existing minimal constructor
    public RegisterRequest(String username, String password, String name, String contact) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.contact = contact;
    }

    // Constructor for Doctor registration
    public RegisterRequest(String username, String password,String role, String name, String contact,
                         String specialization, Integer experience) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.contact = contact;
        this.specialization = specialization;
        this.experience = experience;
    }

    // Constructor for Nurse registration
    public RegisterRequest(String username, String password, String role, String name, String contact,
                         String shift) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.contact = contact;
        this.shift = shift;
    }

    // Constructor for Receptionist registration
    public RegisterRequest(String username, String password,String role, String name, String contact) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.contact = contact;
    }

    // Getters and Setters (keep existing)
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getShift() {
        return shift;
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