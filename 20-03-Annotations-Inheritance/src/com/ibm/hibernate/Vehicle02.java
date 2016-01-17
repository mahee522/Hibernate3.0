package com.ibm.hibernate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
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
 * Default class inheritance mapping strategy.
 * Customize discriminator column & discriminator values
 */

@Entity
@Table(name="VEHICLE")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="VEHICLE_TYPE", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("VeHiCle")
public class Vehicle02 {
	@Id @GeneratedValue
	private long vehicleId;
	private String vehicleName;
	
	public Vehicle02() {	}
	public Vehicle02(String vehicleName) {
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
		
		Vehicle02 vehicle = new Vehicle02("Honda Civic");
		TwoWheeler02 twoWheeler = new TwoWheeler02(); twoWheeler.setSteringHandle("Bike Steering handle"); twoWheeler.setVehicleName("Hero");
		FourWheeler02 fourWheeler = new FourWheeler02(); fourWheeler.setSteeringWheel("Car steering wheel");fourWheeler.setVehicleName("Honda");
		session.save(vehicle);
		session.save(twoWheeler);
		session.save(fourWheeler);
		tx.commit();
		session.close(); 
	}
}
