package org.darktech.entity;

import jakarta.persistence.*;

import java.util.Optional;
import java.util.Set;

import org.darktech.enums.UserStatus;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;

    @Column(nullable = false, length = 100)
    private String doctorName;

    @Column(nullable = false, length = 100)
    private String doctorSpecialization;

    @Column(nullable = false, length = 15)
    private String doctorContact;

    @Column(nullable = false)
    private Integer doctorExperience;
   
    @Enumerated(EnumType.STRING)  // Ensure it's stored as a string in the database
    @Column(nullable = false, length = 20)
    private UserStatus status;


    private boolean active = true;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;


    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "doctor")
    private Set<Patient> patients;

    // Getters and Setters
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

   

    public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}