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
 * OneToOne unidirectional
 */

@Entity 
@Table(name="EMP")
public class Emp02 {

	@Id @GeneratedValue
	int empId;	
	String empName;
	@OneToOne
	Vehicle02 vehicle;

	public Emp02() {	}
	public Emp02(String empName) {
		this.empName = empName; }
	
	public Vehicle02 getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle02 vehicle) {
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
		
		Emp02 emp = new Emp02("Bimal");
		Vehicle02 vehicle = new Vehicle02("Honda Civic");
		emp.setVehicle(vehicle);
		session.save(emp);
		session.save(vehicle);
		tx.commit();
		session.close(); 
	}
}