package org.darktech.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "medical")
public class Medical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicalId;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(nullable = false, length = 50)
    private String medicineName;

    @Column(nullable = false)
    private BigDecimal priceMedicine;

    // Getters and Setters
    public Long getMedicalId() {
        return medicalId;
    }

    public void setMedicalId(Long medicalId) {
        this.medicalId = medicalId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public BigDecimal getPriceMedicine() {
        return priceMedicine;
    }

    public void setPriceMedicine(BigDecimal priceMedicine) {
        this.priceMedicine = priceMedicine;
    }
}