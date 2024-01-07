package com.wipro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Services {
	@Id
	@GeneratedValue
	Integer serviceId;
	String serviceName;	
	float fees;
	
	public Services(Integer serviceId, String serviceName, float fees) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.fees = fees;
	}	
	public Services(String serviceName, float fees) {
		super();
		this.serviceName = serviceName;
		this.fees = fees;
	}	
	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public float getFees() {
		return fees;
	}
	public void setFees(float fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "Service [serviceId=" + serviceId + ", serviceName=" + serviceName + ", fees=" + fees + "]";
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}


}
