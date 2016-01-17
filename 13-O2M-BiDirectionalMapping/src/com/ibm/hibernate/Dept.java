package com.ibm.hibernate;

import java.util.Set;

public class Dept {
	private int deptNo;
	private String deptName;
	private String manager;
	Set<Emp> emps;

	public Dept() { }
	public Dept(int deptNo, String deptName, String manager, Set emps) {
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.manager = manager;	
		this.emps = emps;}

	public int getDeptNo() { return deptNo; }
	public void setDeptNo(int deptNo) { this.deptNo = deptNo; }
	public String getDeptName() { return deptName; }
	public void setDeptName(String deptName) { this.deptName = deptName; }
	public String getManager() { return manager; }
	public void setManager(String manager) { this.manager = manager; }
	public Set<Emp> getEmps() { return emps; }
	public void setEmps(Set<Emp> emps) { this.emps = emps; }
}