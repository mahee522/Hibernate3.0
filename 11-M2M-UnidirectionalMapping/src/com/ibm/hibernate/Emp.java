package com.ibm.hibernate;

import java.util.*;

public class Emp {
	private int id;
	private String name; 
	private int salary;
	private Set certificates;

	public Emp() { }

	public Emp(String name, int salary, Set certificates) {
		this.name = name;
		this.salary = salary;
		this.certificates = certificates; }

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public int getSalary() { return salary; }
	public void setSalary(int salary) { this.salary = salary; }

	public Set getCertificates() { return certificates; }
	public void setCertificates(Set certificates) { this.certificates = certificates; }
}