package com.wipro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Patient {	
	@Id
	private Integer patientId;
	private String firstName;	
	private String lastName;
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Patient(Integer patientId, String firstName, String lastName) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
	}



	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}


}
