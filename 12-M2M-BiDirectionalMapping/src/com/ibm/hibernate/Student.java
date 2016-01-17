package com.ibm.hibernate;

import java.util.Set;

public class Student {
	private int sId;
	private String sName;
	private Set<Course> courses;

	public Student() { }
	public Student(int sId, String sName, Set courses) { this.sId = sId; this.sName = sName; this.courses = courses ;}

	public int getsId() { return sId; }
	public void setsId(int sId) { this.sId = sId; }
	public String getsName() { return sName; }
	public void setsName(String sName) { this.sName = sName; }
	public Set<Course> getCourses() { return courses; }
	public void setCourses(Set<Course> courses) { this.courses = courses; }
}