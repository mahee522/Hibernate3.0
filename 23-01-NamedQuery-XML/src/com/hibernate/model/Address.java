package com.hibernate.model;

public class Address {

	int id;
	String street;
	String city;
	long zip;
	Employee emp;

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getStreet() {	return street;}
	public void setStreet(String street) {	this.street = street;}
	public String getCity() {	return city;}
	public void setCity(String city) {	this.city = city;}
	public long getZip() {	return zip;}
	public void setZip(long zip) {	this.zip = zip;}
	public Employee getEmp() {	return emp;}
	public void setEmp(Employee emp) {	this.emp = emp;}	
	public String toString(){	return "ID:" + getId() + " STREET:" + getStreet() + " SALARY:" + getCity() + " ZIP:" + getZip() + " EMP_NAME:" + getEmp().getName();}
}
