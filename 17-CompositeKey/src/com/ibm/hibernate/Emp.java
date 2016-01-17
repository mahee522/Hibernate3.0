package com.ibm.hibernate;

public class Emp {
	String name;
	EmpCompKey comId;

	public Emp() {}
	public Emp(String name, EmpCompKey comId) {
		this.name = name;
		this.comId = comId;
	}
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
 	public EmpCompKey getComId() { return comId; }
	public void setComId(EmpCompKey comId) { this.comId = comId; }
}