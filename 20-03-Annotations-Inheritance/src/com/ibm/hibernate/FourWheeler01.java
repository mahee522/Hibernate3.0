package com.ibm.hibernate;

import javax.persistence.Entity;

@Entity
public class FourWheeler01 extends Vehicle01{
	private String SteeringWheel;

	public String getSteeringWheel() {
		return SteeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		SteeringWheel = steeringWheel;
	}
}
