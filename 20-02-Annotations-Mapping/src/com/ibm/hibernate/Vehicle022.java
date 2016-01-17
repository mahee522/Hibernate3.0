package com.ibm.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="VEHICLE")
public class Vehicle022 {
	@Id @GeneratedValue
	private long vehicleId;
	private String vehicleName;
	@OneToOne
	private Emp022 emp;
	
	public Vehicle022() {	}
	public Vehicle022(String vehicleName) {
		this.vehicleName = vehicleName; }
	
	
	public Emp022 getEmp() {
		return emp;
	}
	public void setEmp(Emp022 emp) {
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
