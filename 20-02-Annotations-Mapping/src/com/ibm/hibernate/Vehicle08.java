package com.ibm.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="VEHICLE")
public class Vehicle08 {
	@Id @GeneratedValue
	private long vehicleId;
	private String vehicleName;
	@ManyToOne
	@JoinColumn(name="EMPID")
	private Emp08 emp;
	
	public Vehicle08() {	}
	public Vehicle08(String vehicleName) {
		this.vehicleName = vehicleName; }	
	
	public Emp08 getEmp() {
		return emp;
	}
	public void setEmp(Emp08 emp) {
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
