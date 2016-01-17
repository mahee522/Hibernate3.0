package com.ibm.hibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/*
 * Cascade
 */

@Entity 
@Table(name="EMP")
public class Emp12 {

	@Id @GeneratedValue
	int empId;	
	String empName;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="EMP_VEHICLE", joinColumns=@JoinColumn(name="EMP_ID"),
	inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	Collection<Vehicle12> vehicles = new ArrayList<Vehicle12>();

	public Emp12() {	}
	public Emp12(String empName) {this.empName = empName; }	

	public Collection<Vehicle12> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle12> vehicles) {
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
		
		Emp12 emp = new Emp12("Bimal");
		Vehicle12 vehicle = new Vehicle12("Honda Civic");
		Vehicle12 vehicle2 = new Vehicle12("i20");
		emp.getVehicles().add(vehicle);
		emp.getVehicles().add(vehicle2);
		vehicle.getEmp().add(emp);
		session.save(emp); 
		// no need to save vehicle objects separately
		tx.commit();
		session.close(); 
	}
}