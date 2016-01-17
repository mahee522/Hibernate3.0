package com.ibm.hibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/*
 * OneToMany bidirectional
 * mapping in different table
 * customize names for join table & join columns
 */

@Entity 
@Table(name="EMP")
public class Emp06 {

	@Id @GeneratedValue
	int empId;	
	String empName;
	@OneToMany
	@JoinTable(name="EMP_VEHICLE",
				joinColumns=@JoinColumn(name="EMP_ID"),
				inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	Collection<Vehicle06> vehicles = new ArrayList<Vehicle06>();

	public Emp06() {	}
	public Emp06(String empName) {this.empName = empName; }
	

	public Collection<Vehicle06> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle06> vehicles) {
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
		
		Emp06 emp = new Emp06("Bimal");
		Vehicle06 vehicle = new Vehicle06("Honda Civic");
		Vehicle06 vehicle2 = new Vehicle06("i20");
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