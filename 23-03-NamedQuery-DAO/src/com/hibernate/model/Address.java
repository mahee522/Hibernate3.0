package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address {

	@Id
	@Column(name="ADD_ID")
	int id;
	@Column(name="ADDRESS_LINE1")
	String street;
	@Column(name="CITY")
	String city;
	@Column(name="ZIPCODE")
	long zip;
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	Employee emp;
	
	public String toString(){
		return "ID:" + getId() + " STREET:" + getStreet() + " SALARY:" + getCity() + " ZIP:" + getZip() + " EMP_NAME:" + getEmp().getName();
	}
	public int getId() {return id;}
	public void setId(int id) {	this.id = id;}
	public String getStreet() {	return street;}
	public void setStreet(String street) {	this.street = street;}
	public String getCity() {return city;}
	public void setCity(String city) {this.city = city;}
	public long getZip() {	return zip;}
	public void setZip(long zip) {this.zip = zip;}
	public Employee getEmp() {	return emp;}
	public void setEmp(Employee emp) {	this.emp = emp;}
}
