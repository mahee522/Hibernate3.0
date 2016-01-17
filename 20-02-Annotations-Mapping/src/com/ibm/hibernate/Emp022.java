package com.ibm.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/*
 * OneToOne bidirectional
 */

@Entity 
@Table(name="EMP")
public class Emp022 {

	@Id @GeneratedValue
	int empId;	
	String empName;
	@OneToOne
	Vehicle022 vehicle;

	public Emp022() {	}
	public Emp022(String empName) {
		this.empName = empName; }
	
	public Vehicle022 getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle022 vehicle) {
		this.vehicle = vehicle;
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
		
		Emp022 emp = new Emp022("Bimal");
		Vehicle022 vehicle = new Vehicle022("Honda Civic");
		emp.setVehicle(vehicle);
		session.save(emp);
		session.save(vehicle);
		tx.commit();
		session.close(); 
	}
}