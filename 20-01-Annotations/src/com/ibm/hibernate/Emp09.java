package com.ibm.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/*
 * customize table name & column names for collection table
 */

@Entity 
@Table(name="EMP")
public class Emp09 {

	@Id
	@Column (name="ID")
	int eid;
	@Column (name="EMP_NAME")
	String name;
	@CollectionOfElements
	@JoinTable(name="EMP_CONTACT", joinColumns={@JoinColumn(name="EMP_ID")})
	Set<Address06> listOfAddress = new HashSet<Address06>();

	public Emp09() {	}
	public Emp09(String name) {
		this.name = name; }
	
	public int getEid() { return eid; }
	public void setEid(int eid) { this.eid = eid; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public Set<Address06> getListOfAddress() {return listOfAddress;}
	public void setListOfAddress(Set<Address06> listOfAddress) {	this.listOfAddress = listOfAddress;	}
	
	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Address06 homeaddr = new Address06("Fremont","CA");
		Address06 officeaddr = new Address06("SFO","CA");
		Address06 permanentaddr = new Address06("Guwahati","Assam");
		
		Emp09 emp = new Emp09("Bimal");
		emp.getListOfAddress().add(homeaddr);
		emp.getListOfAddress().add(officeaddr);
		emp.getListOfAddress().add(permanentaddr);
		session.save(emp);
		tx.commit();
		session.close(); 
	}
}