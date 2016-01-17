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
 * Separate table per class
 * Child class tables has all the columns related to parent's property, 
 * Child tables inherit parent's generatedValue as well. So each child has an Id as well generated by hibernate
 * You dont have a discriminator here. Infact you dont need it since you have separate table for separate class
 * The tables are slighly more normalized. You dont have extra columns which do not have data. In single class strategy,
 * you have few columns which are mostly null. Which is not an effective database design. But this strategy repeats 
 * parent's columns in every child table.
 */

@Entity
@Table(name="VEHICLE")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Vehicle03 {
	@Id @GeneratedValue
	private long vehicleId;
	private String vehicleName;
	
	public Vehicle03() {	}
	public Vehicle03(String vehicleName) {
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

		Vehicle03 vehicle = new Vehicle03("Honda Civic");
		TwoWheeler03 twoWheeler = new TwoWheeler03(); twoWheeler.setSteringHandle("Bike Steering handle"); twoWheeler.setVehicleName("Hero");
		FourWheeler03 fourWheeler = new FourWheeler03(); fourWheeler.setSteeringWheel("Car steering wheel");fourWheeler.setVehicleName("Honda");
		session.save(vehicle);
		session.save(twoWheeler);
		session.save(fourWheeler);
		tx.commit();
		session.close(); 
	}	
}
