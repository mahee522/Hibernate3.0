package com.ibm.hibernate;

import javax.persistence.Entity;

@Entity
public class TwoWheeler01 extends Vehicle01{
	private String steringHandle;

	public String getSteringHandle() {
		return steringHandle;
	}

	public void setSteringHandle(String steringHandle) {
		this.steringHandle = steringHandle;
	}
}
