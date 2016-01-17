package com.ibm.hibernate;

public class Trainee extends Emp {
	private int cgpi;

	public Trainee() { }
	public Trainee(int id, String name, int salary,int cgpi) {
		super(id, name, salary);
		this.cgpi = cgpi; }

	public int getCgpi() { return cgpi; }
	public void setCgpi(int cgpi) { this.cgpi = cgpi; }
}