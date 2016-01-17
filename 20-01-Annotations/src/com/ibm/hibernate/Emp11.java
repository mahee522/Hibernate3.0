package com.ibm.hibernate;

import java.util.Collection;
import java.util.HashSet;

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
 * Lazy Initialization (default behaviour)
 */

@Entity 
@Table(name="EMP")
public class Emp11 {

	@Id
	@Column (name="ID")
	int eid;
	
	@Column (name="EMP_NAME")
	String name;
	
	@CollectionOfElements
	@JoinTable(name="EMP_CONTACT", joinColumns={@JoinColumn(name="EMP_ID")})
	Collection<Address06> listOfAddress = new HashSet<Address06>();

	public Emp11() {	}
	public Emp11(String name) {
		this.name = name; }
	
	public int getEid() { return eid; }
	public void setEid(int eid) { this.eid = eid; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public Collection<Address06> getListOfAddress() {return listOfAddress;}
	public void setListOfAddress(Collection<Address06> listOfAddress) {	this.listOfAddress = listOfAddress;	}
	
	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Address06 homeaddr = new Address06("Fremont","CA");
		Address06 officeaddr = new Address06("SFO","CA");
		Address06 permanentaddr = new Address06("Guwahati","Assam");
		
		Emp11 emp = new Emp11("Bimal");
		emp.getListOfAddress().add(homeaddr);
		emp.getListOfAddress().add(officeaddr);
		emp.getListOfAddress().add(permanentaddr);
		session.save(emp);
		tx.commit();
		session.close(); 
				
		session = sf.openSession();
		emp=null;
		emp = (Emp11)session.get(Emp11.class, 0);
		session.close(); 
		System.out.println(emp.getName());
		System.out.println(emp.getListOfAddress().size());
	}
}