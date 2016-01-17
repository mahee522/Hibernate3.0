package com.ibm.hibernate;

import java.util.Date;

import javax.persistence.Column;
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
 * Auto Primary key generation
 */

@Entity 
@Table(name="EMP")
public class Emp03 {

	@Id
	@GeneratedValue
	@Column (name="ID")
	int eid;
	@Column (name="NAME")
	String name;

	public Emp03() {	}
	public Emp03(String name, int salary, Date dateAdded, String notes) {this.name = name;}


	public int getEid() { return eid; }
	public void setEid(int eid) { this.eid = eid; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Emp03 emp = new Emp03("Meghna", 4000, new Date(), "Hi Meghna");
		session.save(emp);
		tx.commit();
		session.close(); 
	}
}