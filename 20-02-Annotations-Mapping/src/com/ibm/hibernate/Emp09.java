package com.ibm.hibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/*
 * ManyToMany bidirectional
 * default behaviour of 2 mapping tables
 */

@Entity 
@Table(name="EMP")
public class Emp09 {

	@Id @GeneratedValue
	int empId;	
	String empName;
	@ManyToMany
	Collection<Vehicle09> vehicles = new ArrayList<Vehicle09>();

	public Emp09() {	}
	public Emp09(String empName) {
		this.empName = empName; }
	

	public Collection<Vehicle09> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle09> vehicles) {
		this.vehicles = vehicles;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Emp09 emp = new Emp09("Bimal");
		Vehicle09 vehicle = new Vehicle09("Honda Civic");
		Vehicle09 vehicle2 = new Vehicle09("i20");
		emp.getVehicles().add(vehicle);
		emp.getVehicles().add(vehicle2);
		vehicle.getEmp().add(emp);
		session.save(emp);
		session.save(vehicle);
		session.save(vehicle2);
		tx.commit();
		session.close(); 
	}
}