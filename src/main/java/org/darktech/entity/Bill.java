package org.darktech.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(nullable = false)
    private BigDecimal roomCharges;

    @Column(nullable = false)
    private BigDecimal treatmentCharges;

    @Column(nullable = false)
    private BigDecimal nurseCharges;

    @Column(nullable = false)
    private BigDecimal medicineCharges;

    @Column(nullable = false)
    private BigDecimal totalAmount;

    @Temporal(TemporalType.DATE)
    private Date billingDate;

    // Getters and Setters
    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public BigDecimal getRoomCharges() {
        return roomCharges;
    }

    public void setRoomCharges(BigDecimal roomCharges) {
        this.roomCharges = roomCharges;
    }

    public BigDecimal getTreatmentCharges() {
        return treatmentCharges;
    }

    public void setTreatmentCharges(BigDecimal treatmentCharges) {
        this.treatmentCharges = treatmentCharges;
    }

    public BigDecimal getNurseCharges() {
        return nurseCharges;
    }

    public void setNurseCharges(BigDecimal nurseCharges) {
        this.nurseCharges = nurseCharges;
    }

    public BigDecimal getMedicineCharges() {
        return medicineCharges;
    }

    public void setMedicineCharges(BigDecimal medicineCharges) {
        this.medicineCharges = medicineCharges;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }
}