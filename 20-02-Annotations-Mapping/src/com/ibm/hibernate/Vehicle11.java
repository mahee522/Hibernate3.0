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
public class Vehicle11 {
	@Id @GeneratedValue
	private long vehicleId;
	private String vehicleName;
	@ManyToMany(mappedBy="vehicles")
	private Collection<Emp11> emp = new ArrayList<Emp11>();
	
	public Vehicle11() {	}
	public Vehicle11(String vehicleName) {this.vehicleName = vehicleName; }	

	public Collection<Emp11> getEmp() {
		return emp;
	}
	public void setEmp(Collection<Emp11> emp) {
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
