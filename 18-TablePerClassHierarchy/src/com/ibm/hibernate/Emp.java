package com.ibm.hibernate;

public class Emp extends Person {
	private int salary;

	public Emp() {}
	
	public Emp(int id, String name, int salary) { 
		super(id,name);
		this.salary = salary; }
	public int getSalary() { return salary; }
	public void setSalary(int salary) { this.salary = salary; }
}