package com.ibm.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="VEHICLE")
public class Vehicle01 {
	@Id @GeneratedValue
	private long vehicleId;
	private String vehicleName;
	
	public Vehicle01() {	}
	public Vehicle01(String vehicleName) {
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
