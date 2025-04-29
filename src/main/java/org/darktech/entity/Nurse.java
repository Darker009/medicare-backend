package org.darktech.entity;

import jakarta.persistence.*;
import org.darktech.enums.Shift;
import java.util.Set;

@Entity
@Table(name = "nurse")
public class Nurse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nurseId;

    @Column(nullable = false, length = 100)
    private String nurseName;

    @Column(nullable = false, length = 15)
    private String nurseContact;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Shift nurseShift;

    private boolean active = true;

    @OneToMany(mappedBy = "nurse")
    private Set<Patient> patients;

	 @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    // Getters and Setters
    public Long getNurseId() {
        return nurseId;
    }

    public void setNurseId(Long nurseId) {
        this.nurseId = nurseId;
    }

    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    public String getNurseContact() {
        return nurseContact;
    }

    public void setNurseContact(String nurseContact) {
        this.nurseContact = nurseContact;
    }

    public Shift getNurseShift() {
        return nurseShift;
    }

    public void setNurseShift(Shift nurseShift) {
        this.nurseShift = nurseShift;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    public void setUser(User user) {
        this.user = user;
    }
}