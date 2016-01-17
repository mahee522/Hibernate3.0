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
public class Vehicle10 {
	@Id @GeneratedValue
	private long vehicleId;
	private String vehicleName;
	@ManyToMany(mappedBy="vehicles")
	private Collection<Emp10> emp = new ArrayList<Emp10>();
	
	public Vehicle10() {	}
	public Vehicle10(String vehicleName) {this.vehicleName = vehicleName; }	
	
	public Collection<Emp10> getEmp() {
		return emp;
	}
	public void setEmp(Collection<Emp10> emp) {
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
