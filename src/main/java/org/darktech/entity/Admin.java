package org.darktech.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    @Column
    private String adminName;
    
    @Column(length = 15)
    private String adminContact;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "admin")
    private Set<Doctor> doctors;

    @OneToMany(mappedBy = "admin")
    private Set<Reception> receptions;

    // Getters and Setters
    
    
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Set<Reception> getReceptions() {
        return receptions;
    }

    public void setReceptions(Set<Reception> receptions) {
        this.receptions = receptions;
    }
}