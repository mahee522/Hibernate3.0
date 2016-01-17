package com.ibm.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="VEHICLE")
public class Vehicle06 {
	@Id @GeneratedValue
	private long vehicleId;
	private String vehicleName;
	@ManyToOne
	private Emp06 emp;
	
	public Vehicle06() {	}
	public Vehicle06(String vehicleName) {
		this.vehicleName = vehicleName; }
	
	
	public Emp06 getEmp() {
		return emp;
	}
	public void setEmp(Emp06 emp) {
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
