package com.ibm.hibernate;

import java.util.ArrayList;
import java.util.Collection;

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
 * ManyToMany bidirectional
 * customize mapping table
 */

@Entity 
@Table(name="EMP")
public class Emp11 {

	@Id @GeneratedValue
	int empId;	
	String empName;
	@ManyToMany
	@JoinTable(name="EMP_VEHICLE", joinColumns=@JoinColumn(name="EMP_ID"),
	inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	Collection<Vehicle11> vehicles = new ArrayList<Vehicle11>();

	public Emp11() {	}
	public Emp11(String empName) {this.empName = empName; }	

	public Collection<Vehicle11> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle11> vehicles) {
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
		
		Emp11 emp = new Emp11("Bimal");
		Vehicle11 vehicle = new Vehicle11("Honda Civic");
		Vehicle11 vehicle2 = new Vehicle11("i20");
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