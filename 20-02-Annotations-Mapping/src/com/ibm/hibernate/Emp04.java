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
 * OneToMany unidirectional
 * mapping in different table
 */

@Entity 
@Table(name="EMP")
public class Emp04 {

	@Id @GeneratedValue
	int empId;	
	String empName;
	@OneToMany
	Collection<Vehicle04> vehicles = new ArrayList<Vehicle04>();

	public Emp04() {	}
	public Emp04(String empName) {this.empName = empName; }
	
	public Collection<Vehicle04> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle04> vehicles) {
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
		
		Emp04 emp = new Emp04("Bimal");
		Vehicle04 vehicle = new Vehicle04("Honda Civic");
		Vehicle04 vehicle2 = new Vehicle04("i20");
		emp.getVehicles().add(vehicle);
		emp.getVehicles().add(vehicle2);
		session.save(emp);
		session.save(vehicle);
		session.save(vehicle2);
		tx.commit();
		session.close(); 
	}
}