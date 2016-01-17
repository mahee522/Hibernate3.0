package com.ibm.hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="FOUR_WHEELER")
public class FourWheeler03 extends Vehicle03{
	private String SteeringWheel;

	public String getSteeringWheel() {
		return SteeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		SteeringWheel = steeringWheel;
	}
}
