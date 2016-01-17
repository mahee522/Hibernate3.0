package com.ibm.hibernate;

import java.util.Set;

public class Course {
	private int cId;
	private String cName;
	private Set<Student> students;

	public Course() {}
	public Course(int cId, String cName) { this.cId = cId; this.cName = cName; }

	public int getcId() { return cId; }
	public void setcId(int cId) { this.cId = cId; }
	public String getcName() { return cName; }
	public void setcName(String cName) { this.cName = cName; }
	public Set<Student> getStudents() { return students; }
	public void setStudents(Set<Student> students) { this.students = students; }
}