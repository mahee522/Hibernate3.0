package com.ibm.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/*
 * Joined strategy is again TablePerClass strategy.
 * But this is strategy creates more normalized tables than TablePerClass strategy, since the data from the parent tables 
 * are not copied to each child classes
 * We will have to do a join to get the entire data as:
 * select * from table1 join table2 on table1.id=table2.id
 */

@Entity
@Table(name="VEHICLE")
@Inheritance(strategy=InheritanceType.JOINED)
public class Vehicle04 {
	@Id @GeneratedValue
	private long vehicleId;
	private String vehicleName;
	
	public Vehicle04() {	}
	public Vehicle04(String vehicleName) {
		this.vehicleName = vehicleName; }
	
	public long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Vehicle04 vehicle = new Vehicle04("Honda Civic");
		TwoWheeler04 twoWheeler = new TwoWheeler04(); twoWheeler.setSteringHandle("Bike Steering handle"); twoWheeler.setVehicleName("Hero");
		FourWheeler04 fourWheeler = new FourWheeler04(); fourWheeler.setSteeringWheel("Car steering wheel");fourWheeler.setVehicleName("Honda");
		session.save(vehicle);
		session.save(twoWheeler);
		session.save(fourWheeler);
		tx.commit();
		session.close(); 
	}
	
}
