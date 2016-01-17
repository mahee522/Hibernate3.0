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
 * use mappedBy to get only one mapping table
 */

@Entity 
@Table(name="EMP")
public class Emp10 {

	@Id @GeneratedValue
	int empId;	
	String empName;
	@ManyToMany
	Collection<Vehicle10> vehicles = new ArrayList<Vehicle10>();

	public Emp10() {	}
	public Emp10(String empName) {this.empName = empName; }	

	public Collection<Vehicle10> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle10> vehicles) {
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
		
		Emp10 emp = new Emp10("Bimal");
		Vehicle10 vehicle = new Vehicle10("Honda Civic");
		Vehicle10 vehicle2 = new Vehicle10("i20");
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