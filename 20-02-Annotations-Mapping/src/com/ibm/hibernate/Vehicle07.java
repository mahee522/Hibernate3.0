package com.ibm.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="VEHICLE")
public class Vehicle07 {
	@Id @GeneratedValue
	private long vehicleId;
	private String vehicleName;
	@ManyToOne
	private Emp07 emp;
	
	public Vehicle07() {	}
	public Vehicle07(String vehicleName) { this.vehicleName = vehicleName; }	
	
	public Emp07 getEmp() {
		return emp;
	}
	public void setEmp(Emp07 emp) {
		this.emp = emp;
	}
	public long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
}
