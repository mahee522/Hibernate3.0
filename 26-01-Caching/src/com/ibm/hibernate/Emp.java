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
 * detached to persistent state
 */

@Entity 
@Table(name="EMP")
public class Emp {

	@Id @GeneratedValue
	int empId;	
	String empName;	

	public Emp() {	}
	public Emp(String empName) {
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
		Emp emp = new Emp("Bimal");
		session.save(emp);
		session.get(Emp.class, 1);
		tx.commit();
		// Moving object from persistent to detached
		session.close(); 
		System.out.println();
		
		emp.setEmpName("Bimal Jain");
		
		// Moving object from detached to persistent
		System.out.println("Change made while object was detached");
		session = sf.openSession();
		tx = session.beginTransaction();	
		session.update(emp);
		tx.commit();
		session.close(); 
		System.out.println();
		
		System.out.println("NO change while object was detached");
		
		// Moving object from detached to persistent. 
		// Still fires update query, as hibernate cannot track the object after the session was closed. 
		// So to be safe, hibernate fires an update query.
		session = sf.openSession();
		tx = session.beginTransaction();	
		session.update(emp);
		tx.commit();
		session.close(); 
		System.out.println();
		
		emp.setEmpName("Bimal Jain");
		
		// Moving object from detached to persistent
		// More changes made once the object is persisted. But there is only one update query, since
		// hibernate is tracking all the changes in the cache
		session = sf.openSession();
		tx = session.beginTransaction();
		System.out.println("Multiple changes done, but only one update SQL");
		session.update(emp);
		emp.setEmpName("Bimal changed again");
		tx.commit();
		session.close();

	}
}