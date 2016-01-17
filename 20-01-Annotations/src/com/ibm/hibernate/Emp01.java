package com.ibm.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/*
 * Minimum Annotation requirement
 * Default table & column names
 */

@Entity
public class Emp01 {

	@Id
	int eid;
	String name;

	public Emp01() {	}
	public Emp01(String name) {this.name = name;}

	public int getEid() { return eid; }
	public void setEid(int eid) { this.eid = eid; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Emp01 emp = new Emp01("Bimal");
		System.out.println("Insert data: ");
		session.save(emp);
		tx.commit();
		session.close(); 
		
		session = sf.openSession();
		tx = session.beginTransaction();
		System.out.println("Update data: ");
		emp = (Emp01)session.get(Emp01.class, 0);
		emp.setName("Meghna");
		session.update(emp);
		tx.commit();
		session.close();
		
		session = sf.openSession();
		tx = session.beginTransaction();
		System.out.println("Delete data:");
		emp = (Emp01)session.get(Emp01.class, 0);
		session.delete(emp);
		tx.commit();
		session.close();		
	}
}