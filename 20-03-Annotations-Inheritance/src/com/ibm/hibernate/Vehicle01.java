package com.ibm.hibernate;

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
 * Default class inheritance mapping strategy. Its one common table per class hierarchy
 * Discriminator column maintains the actual class name. This column tells you what kind of object the row represents.
 */

@Entity
@Table(name="VEHICLE")
public class Vehicle01 {
	@Id @GeneratedValue
	private long vehicleId;
	private String vehicleName;
	
	public Vehicle01() {	}
	public Vehicle01(String vehicleName) {
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
		
		Vehicle01 vehicle = new Vehicle01("Honda Civic");
		TwoWheeler01 twoWheeler = new TwoWheeler01(); twoWheeler.setSteringHandle("Bike Steering handle"); twoWheeler.setVehicleName("Hero");
		FourWheeler01 fourWheeler = new FourWheeler01(); fourWheeler.setSteeringWheel("Car steering wheel");fourWheeler.setVehicleName("Honda");
		session.save(vehicle);
		session.save(twoWheeler);
		session.save(fourWheeler);
		tx.commit();
		session.close(); 
	}
}
