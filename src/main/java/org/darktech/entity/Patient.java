package org.darktech.entity;

import jakarta.persistence.*;
import org.darktech.enums.Gender;
import org.darktech.enums.PatientStatus;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    @Column(nullable = false, length = 100)
    private String patientName;

    private Integer patientAge;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender patientGender;

    @Column(nullable = false, length = 15)
    private String patientContact;

    @Column(nullable = false, length = 255)
    private String patientIssue;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date admittedDate;

    @Temporal(TemporalType.DATE)
    private Date dischargeDate;

    @ManyToOne
    @JoinColumn(name = "room_no")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "nurse_id")
    private Nurse nurse;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PatientStatus status;

    @OneToMany(mappedBy = "patient")
    private Set<Medical> medicalRecords;

    @OneToMany(mappedBy = "patient")
    private Set<Bill> bills;

    // Getters and Setters
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public Gender getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(Gender patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientContact() {
        return patientContact;
    }

    public void setPatientContact(String patientContact) {
        this.patientContact = patientContact;
    }

    public String getPatientIssue() {
        return patientIssue;
    }

    public void setPatientIssue(String patientIssue) {
        this.patientIssue = patientIssue;
    }

    public Date getAdmittedDate() {
        return admittedDate;
    }

    public void setAdmittedDate(Date admittedDate) {
        this.admittedDate = admittedDate;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public PatientStatus getStatus() {
        return status;
    }

    public void setStatus(PatientStatus status) {
        this.status = status;
    }

    public Set<Medical> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(Set<Medical> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }
}