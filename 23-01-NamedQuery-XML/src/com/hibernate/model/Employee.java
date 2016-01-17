package com.hibernate.model;

import java.util.Collection;
import java.util.HashSet;

public class Employee {
	int id;
	String name;
	int salary;
	Collection<Address> addresses = new HashSet<Address>();
	
	public int getId() {return id;}
	public void setId(int id) {	this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getSalary() {return salary;}
	public void setSalary(int salary) {	this.salary = salary;}
	public Collection<Address> getAddresses() {	return addresses;}
	public void setAddresses(Collection<Address> addresses) {this.addresses = addresses;}	
	public String toString(){return "ID:" + getId() + " NAME:" + getName() + " SALARY:" + getSalary();}		
}
