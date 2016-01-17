package com.ibm.hibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name="VEHICLE")
public class Vehicle09 {
	@Id @GeneratedValue
	private long vehicleId;
	private String vehicleName;
	@ManyToMany
	private Collection<Emp09> emp = new ArrayList<Emp09>();
	
	public Vehicle09() {	}
	public Vehicle09(String vehicleName) {
		this.vehicleName = vehicleName; }	
	

	public Collection<Emp09> getEmp() {
		return emp;
	}
	public void setEmp(Collection<Emp09> emp) {
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
