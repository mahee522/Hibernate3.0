package com.ibm.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/*
 * Caching with 2nd level cache
 */

@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="EMP")
public class Emp02 {

	@Id @GeneratedValue
	int empId;
	@Column(name="NAME")
	String empName;	

	public Emp02() {	}
	public Emp02(String empName) {
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
		System.out.println("1st session");
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Emp02 emp = new Emp02("Bimal");
		session.save(emp);
		tx.commit();
		session.close(); 
		
		System.out.println("2nd session");
		session = sf.openSession();
		tx = session.beginTransaction();
		session.get(Emp02.class, 1);
		session.get(Emp02.class, 1);
		tx.commit();
		session.close(); 
		
		System.out.println("3rd session");
		session = sf.openSession();
		tx = session.beginTransaction();
		emp = (Emp02) session.get(Emp02.class, 1);
		emp.setEmpName("Updated Bimal");
		session.get(Emp02.class, 1);
		tx.commit();
		session.close(); 
		
		System.out.println("4th session");
		session = sf.openSession();
		tx = session.beginTransaction();		
		session.get(Emp02.class, 1);
		tx.commit();
		session.close(); 
	}
}