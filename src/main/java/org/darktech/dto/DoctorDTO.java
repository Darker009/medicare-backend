package org.darktech.dto;

public class DoctorDTO {
	private Long doctorId;
    private String doctorName;
    private String doctorSpecialization;
    private String doctorContact;
    private int doctorExperience;
	public DoctorDTO(Long doctorId, String doctorName, String doctorSpecialization, String doctorContact,
			int doctorExperience) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorSpecialization = doctorSpecialization;
		this.doctorContact = doctorContact;
		this.doctorExperience = doctorExperience;
	}
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
	public int getDoctorExperience() {
		return doctorExperience;
	}
	public void setDoctorExperience(int doctorExperience) {
		this.doctorExperience = doctorExperience;
	}
    
    
}
