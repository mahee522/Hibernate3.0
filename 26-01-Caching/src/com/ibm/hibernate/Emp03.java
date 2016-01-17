package com.ibm.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/*
 * Query cache
 */

@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="EMP")
public class Emp03 {

	@Id @GeneratedValue
	int empId;
	@Column(name="NAME")
	String empName;	

	public Emp03() {	}
	public Emp03(String empName) {
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
		Emp03 emp = new Emp03("Bimal");
		session.save(emp);
		tx.commit();
		session.close(); 
		
		System.out.println("2nd session");
		session = sf.openSession();
		tx = session.beginTransaction();
		Query query = session.createQuery("from Emp03");
		query.setCacheable(true);
		query.list();		
		tx.commit();
		session.close(); 
		
		System.out.println("3rd session");
		session = sf.openSession();
		tx = session.beginTransaction();		
		query = session.createQuery("from Emp03");
		query.list();		
		tx.commit();
		session.close(); 
		
		System.out.println("4th session");
		session = sf.openSession();
		tx = session.beginTransaction();		
		query = session.createQuery("from Emp03");
		query.setCacheable(true);
		query.list();		
		tx.commit();
		session.close(); 		
	}
}