package com.ibm.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="VEHICLE")
public class Vehicle05 {
	@Id @GeneratedValue
	private long vehicleId;
	private String vehicleName;
	@ManyToOne
	private Emp05 emp;
	
	public Vehicle05() {	}
	public Vehicle05(String vehicleName) { this.vehicleName = vehicleName; }
		
	public Emp05 getEmp() {
		return emp;
	}
	public void setEmp(Emp05 emp) {
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
