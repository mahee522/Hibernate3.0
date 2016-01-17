package com.ibm.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/*
 * Primary key generation using DB sequence
 * 
  CREATE SEQUENCE emp_seq
  START WITH 1
  INCREMENT BY 1
  NOCACHE;

CREATE OR REPLACE TRIGGER emp_trigger 
BEFORE INSERT ON emp
FOR EACH ROW

BEGIN
  SELECT emp_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;
 */

@Entity 
@Table(name="EMP")
public class Emp04 {

	@Id
	@GeneratedValue (strategy=GenerationType.SEQUENCE, generator="custom_sequence")
	@SequenceGenerator(name = "custom_sequence", sequenceName="emp_seq")
	@Column (name="ID")
	int eid;
	@Column (name="NAME")
	String name;

	public Emp04() {	}
	public Emp04(String name, int salary, Date dateAdded, String notes) {this.name = name;}


	public int getEid() { return eid; }
	public void setEid(int eid) { this.eid = eid; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Emp04 emp = new Emp04("Meghna", 4000, new Date(), "Hi Meghna");
		session.save(emp);
		tx.commit();
		session.close(); 
	}
}