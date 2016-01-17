package com.ibm.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/*
 * OneToOne unidirectional
 * Customize join column name
 */

@Entity 
@Table(name="EMP")
public class Emp03 {

	@Id @GeneratedValue
	int empId;	
	String empName;
	@OneToOne
	@JoinColumn(name="VEHICLE_ID")
	Vehicle03 vehicle;

	public Emp03() {	}
	public Emp03(String empName) {
		this.empName = empName; }
	
	public Vehicle03 getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle03 vehicle) {
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
		
		Emp03 emp = new Emp03("Bimal");
		Vehicle03 vehicle = new Vehicle03("Honda Civic");
		emp.setVehicle(vehicle);
		session.save(emp);
		session.save(vehicle);
		tx.commit();
		session.close(); 
	}
}