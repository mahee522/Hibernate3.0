package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee {

	@Id
	@Column(name="EMP_ID")
	int id;
	@Column(name="EMP_NAME")
	String name;
	@Column(name="EMP_SALARY")
	int salary;
	
	public String toString(){return "ID:" + getId() + " NAME:" + getName() + " SALARY:" + getSalary();}
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {	this.name = name;}
	public int getSalary() {return salary;}
	public void setSalary(int salary) {	this.salary = salary;}
}
