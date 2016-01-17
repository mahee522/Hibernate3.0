package com.ibm.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/*
 * Customize table and column names
 */

@Entity (name="EMP")
public class Emp02 {

	@Id
	@Column (name="ID")
	int eid;
	@Column (name="NAME")
	String name;
	@Transient
	int salary;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_ADDED")
	Date dateAdded;
	@Lob
	@Column(name="NOTES")
	String notes;

	public Emp02() {	}
	public Emp02(String name, int salary, Date dateAdded, String notes) {this.name = name; this.salary=salary; this.dateAdded=dateAdded; this.notes=notes;}

	public int getSalary() {return salary;}
	public void setSalary(int salary) {this.salary = salary;}
	public int getEid() { return eid; }
	public void setEid(int eid) { this.eid = eid; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public Date getDateAdded() {return dateAdded;}
	public void setDateAdded(Date dateAdded) {this.dateAdded = dateAdded;}
	
	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Emp02 emp = new Emp02("Bimal", 4000, new Date(), "Hi Bimal");
		session.save(emp);
		tx.commit();
		session.close(); 
	}
}