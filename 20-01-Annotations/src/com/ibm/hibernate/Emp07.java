package com.ibm.hibernate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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
 * override attributes of embedded object
 */

@Entity 
@Table(name="EMP")
public class Emp07 {

	@Id
	@Column (name="ID")
	int eid;
	@Column (name="NAME")
	String name;
	@Embedded
	@AttributeOverrides({@AttributeOverride(name="city", column=@Column(name="HOME_CITY")),
						 @AttributeOverride(name="state", column=@Column(name="HOME_STATE"))})
	Address06 homeAddress;
	@Embedded
	@AttributeOverrides({@AttributeOverride(name="city", column=@Column(name="OFFICE_CITY")),
		 @AttributeOverride(name="state", column=@Column(name="OFFICE_STATE"))})
	Address06 officeAddress;

	public Emp07() {	}
	public Emp07(String name, Address06 homeAddress, Address06 officeAddress) {
		this.name = name; this.homeAddress=homeAddress; this.officeAddress=officeAddress;}
	
	public int getEid() { return eid; }
	public void setEid(int eid) { this.eid = eid; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Address06 homeaddr = new Address06("Fremont","CA");
		Address06 officeaddr = new Address06("SFO","CA"); 
		Emp07 emp = new Emp07("Bimal", homeaddr, officeaddr);
		session.save(emp);
		tx.commit();
		session.close(); 
	}
}