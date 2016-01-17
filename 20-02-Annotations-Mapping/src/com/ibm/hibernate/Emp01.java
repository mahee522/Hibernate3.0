package com.ibm.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/*
 * persisting 2 entities without setting any relationship between them
 * each entity will have a separate table
 * there is no join column
 */

@Entity 
@Table(name="EMP")
public class Emp01 {

	@Id @GeneratedValue
	int empId;	
	String empName;	

	public Emp01() {	}
	public Emp01(String empName) {
		this.empName = empName; }
	
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
		
		Emp01 emp = new Emp01("Bimal");
		Vehicle01 vehicle = new Vehicle01("Honda Civic");
		session.save(emp);
		session.save(vehicle);
		tx.commit();
		session.close(); 
	}
}