package com.ibm.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="VEHICLE")
public class Vehicle03 {
	@Id 
	@GeneratedValue
	private long vehicleId;
	private String vehicleName;
	
	public Vehicle03() {	}
	public Vehicle03(String vehicleName) {
		this.vehicleName = vehicleName; }
	
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
