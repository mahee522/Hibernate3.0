package com.ibm.hibernate;

public class Emp {
	private int id;
	private String name; 
	private int salary;
	private Address address;

	public Emp() { }

	public Emp(String name, int salary, Address address) {
		this.name = name;
		this.salary = salary;
		this.address = address; }

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public int getSalary() { return salary; }
	public void setSalary(int salary) { this.salary = salary; }

	public Address getAddress() { return address; }
	public void setAddress(Address address) { this.address = address; }
}