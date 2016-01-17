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
 * customized embedded columns
 */

@Entity 
@Table(name="EMP")
public class Emp06 {

	@Id
	@Column (name="ID")
	int eid;
	@Column (name="NAME")
	String name;
	@Embedded
	Address06 address;

	public Emp06() {	}
	public Emp06(String name, Address06 address) {this.name = name; this.address=address;}
	
	public int getEid() { return eid; }
	public void setEid(int eid) { this.eid = eid; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Address06 addr = new Address06("Fremont","CA");
		Emp06 emp = new Emp06("Meghna", addr);
		session.save(emp);
		tx.commit();
		session.close(); 
	}
}