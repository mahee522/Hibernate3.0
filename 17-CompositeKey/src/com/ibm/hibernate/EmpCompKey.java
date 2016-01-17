package com.ibm.hibernate;

import java.io.Serializable;
public class EmpCompKey implements Serializable {
	private int eid;
	private int dependents;

	public EmpCompKey() {}
	public EmpCompKey(int eid, int dependents) {
		this.eid = eid;
		this.dependents = dependents;
	}
	public int getEid() { return eid; }
	public void setEid(int eid) { this.eid = eid; }
	public int getDependents() { return dependents; }
	public void setDependents(int dependents) { this.dependents = dependents; }
}