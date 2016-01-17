package com.ibm.hibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/*
 * OneToMany bidirectional
 * mapping in same table
 * this cannot be done in One To Many unidirectional
 */

@Entity 
@Table(name="EMP")
public class Emp07 {

	@Id @GeneratedValue
	int empId;	
	String empName;
	@OneToMany(mappedBy="emp")
	Collection<Vehicle07> vehicles = new ArrayList<Vehicle07>();

	public Emp07() {	}
	public Emp07(String empName) {this.empName = empName; }	

	public Collection<Vehicle07> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle07> vehicles) {
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
		
		Emp07 emp = new Emp07("Bimal");
		Vehicle07 vehicle = new Vehicle07("Honda Civic");
		Vehicle07 vehicle2 = new Vehicle07("i20");
		emp.getVehicles().add(vehicle);
		emp.getVehicles().add(vehicle2);
		vehicle.setEmp(emp); 
		vehicle2.setEmp(emp);
		session.save(emp);
		session.save(vehicle);
		session.save(vehicle2);
		tx.commit();
		session.close(); 
	}
}