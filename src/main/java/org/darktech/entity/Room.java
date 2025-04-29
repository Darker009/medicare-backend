package org.darktech.entity;

import jakarta.persistence.*;
import org.darktech.enums.RoomStatus;
import org.darktech.enums.RoomType;
import java.util.Set;

@Entity
@Table(name = "room")
public class Room {
    @Id
    private Integer roomNo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomType roomType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomStatus roomStatus;

    @Column(nullable = false)
    private Double chargesPerDay;

    @OneToMany(mappedBy = "room")
    private Set<Patient> patients;

    // Getters and Setters
    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Double getChargesPerDay() {
        return chargesPerDay;
    }

    public void setChargesPerDay(Double chargesPerDay) {
        this.chargesPerDay = chargesPerDay;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}