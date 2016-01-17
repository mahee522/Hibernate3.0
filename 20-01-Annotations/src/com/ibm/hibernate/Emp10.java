package com.ibm.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/*
 * Add Primary key for embedded collection
 */

@Entity 
@Table(name="EMP")
public class Emp10 {

	@Id
	@Column (name="ID")
	int eid;
	
	@Column (name="EMP_NAME")
	String name;
	
	@CollectionOfElements
	@JoinTable(name="EMP_CONTACT", joinColumns={@JoinColumn(name="EMP_ID")})	
	@GenericGenerator(name = "hiloGenerator", strategy = "hilo")
	@CollectionId(columns= {@Column(name="CONTACT_ID")}, generator = "hiloGenerator", type = @Type(type="long"))
	List<Address06> listOfAddress = new ArrayList<Address06>();

	public Emp10() {	}
	public Emp10(String name) {
		this.name = name; }
	
	public int getEid() { return eid; }
	public void setEid(int eid) { this.eid = eid; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public List<Address06> getListOfAddress() {return listOfAddress;}
	public void setListOfAddress(List<Address06> listOfAddress) {	this.listOfAddress = listOfAddress;	}
	
	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Address06 homeaddr = new Address06("Fremont","CA");
		Address06 officeaddr = new Address06("SFO","CA");
		Address06 permanentaddr = new Address06("Guwahati","Assam");
		
		Emp10 emp = new Emp10("Bimal");
		emp.getListOfAddress().add(homeaddr);
		emp.getListOfAddress().add(officeaddr);
		emp.getListOfAddress().add(permanentaddr);
		session.save(emp);
		tx.commit();
		session.close(); 
	}
}