package com.ibm.hibernate;

public class Emp {
	int eid;
	String name;
	Address address;
	double salary;

	public Emp() {	}
	public Emp(String name, Address address, double salary) {
		this.name = name;
		this.address = address;
		this.salary = salary;	}

	public int getEid() { return eid; }
	public void setEid(int eid) { this.eid = eid; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public Address getAddress() { return address; }
	public void setAddress(Address address) { this.address = address; }

	public double getSalary() { return salary; }
	public void setSalary(double salary) { this.salary = salary; }
}