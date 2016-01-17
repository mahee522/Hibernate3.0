package com.ibm.hibernate;

import javax.persistence.Embeddable;

@Embeddable
public class Address05 {
	private String city;
	private String state;
	
	public Address05(){ }
	public Address05(String city, String state){this.city=city; this.state=state; }
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}	
}
