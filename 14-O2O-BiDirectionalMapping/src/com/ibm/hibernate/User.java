package com.ibm.hibernate;

public class User {
	int uid;
	String name;
	Address address;

	public User() {}
	public User(int uid, String name, Address address) {
		this.uid = uid;
		this.name = name;
		this.address = address; }

	public int getUid() { return uid; }
	public void setUid(int uid) { this.uid = uid; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public Address getAddress() { return address; }
	public void setAddress(Address address) { this.address = address; }
}