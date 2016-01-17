package com.ibm.hibernate;

import java.util.Set;

public class User {
	int userId;
	String name;
	Set cars;

	public User() {	}
	public User(String name, Set cars) { this.name = name;  this.cars = cars; }
	public int getUserId() { return userId; }
	public void setUserId(int uid) { this.userId = uid; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public Set getCars() { return cars; }
	public void setCars(Set cars) { this.cars = cars; }
}