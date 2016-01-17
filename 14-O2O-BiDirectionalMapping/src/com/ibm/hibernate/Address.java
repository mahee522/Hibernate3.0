package com.ibm.hibernate;

public class Address {
	int doorNo;
	String city;
	long pin;
	User user;

	public Address() {}
	public Address(int doorNo, String city, long pin, User user) {
		this.doorNo = doorNo;
		this.city = city;
		this.pin = pin;
		this.user = user;	}

	public User getUser() { return user; }
	public void setUser(User user) { this.user = user; }
	public int getDoorNo() { return doorNo; }
	public void setDoorNo(int doorNo) { this.doorNo = doorNo; }
	public String getCity() { return city; }
	public void setCity(String city) { this.city = city; }
	public long getPin() { return pin; }
	public void setPin(long pin) { this.pin = pin; }
}