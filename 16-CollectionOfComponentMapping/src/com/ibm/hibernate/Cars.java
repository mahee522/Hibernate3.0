package com.ibm.hibernate;

public class Cars {
	String carName;
	String make;
	String model;
	
	public Cars() {	}
	public Cars(String carName, String make, String model) {
		this.carName = carName;
		this.make = make;
		this.model = model;
	}
	public String getCarName() { return carName; }
	public void setCarName(String carName) { this.carName = carName; }
	public String getMake() { return make; }
	public void setMake(String make) { this.make = make; }
	public String getModel() { return model; }
	public void setModel(String model) { this.model = model; }
}