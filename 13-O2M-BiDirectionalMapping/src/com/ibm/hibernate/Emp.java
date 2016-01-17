package com.ibm.hibernate;

public class Emp {
	private int eid;
	private String name;
	private double salary;
	private Dept dept;

	public Emp() { }
	public Emp(int eid, String name, double salary) {
		this.eid = eid;
		this.name = name;
		this.salary = salary;	}

	public int getEid() { return eid; }
	public void setEid(int eid) { this.eid = eid; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public double getSalary() { return salary; }
	public void setSalary(double salary) { this.salary = salary; }
	public Dept getDept() { return dept; }
	public void setDept(Dept dept) { this.dept = dept; }
}