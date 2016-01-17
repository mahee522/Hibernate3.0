package com.ibm.hibernate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/*
 * Embedded Object
 */

@Entity 
@Table(name="EMP")
public class Emp05 {

	@Id
	@Column (name="ID")
	int eid;
	@Column (name="NAME")
	String name;
	@Embedded
	Address05 address;

	public Emp05() {	}
	public Emp05(String name, Address05 address) {this.name = name; this.address=address;}
	
	public int getEid() { return eid; }
	public void setEid(int eid) { this.eid = eid; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Address05 addr = new Address05("Fremont","CA");
		Emp05 emp = new Emp05("Meghna", addr);
		session.save(emp);
		tx.commit();
		session.close(); 
	}
}