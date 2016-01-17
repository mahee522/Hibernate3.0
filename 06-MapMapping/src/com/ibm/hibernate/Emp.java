package com.ibm.hibernate;

import java.util.*;

public class Emp {
	private int id;
	private String name; 
	private String address;   
	private int salary;
	private Map certificates;

	public Emp() { }

	public Emp(String name, String address, int salary, Map certificates) {
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.certificates = certificates;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }

	public int getSalary() { return salary; }
	public void setSalary(int salary) { this.salary = salary; }

	public Map getCertificates() { return certificates; }
	public void setCertificates(Map certificates) { this.certificates = certificates; }
}