package com.ibm.hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address06 {
	@Column(name="CITY")
	private String city;
	@Column(name="STATE")
	private String state;
	
	public Address06(){ }
	public Address06(String city, String state){this.city=city; this.state=state; }
	
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