package com.ibm.hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2WhEeLer")
public class TwoWheeler02 extends Vehicle02{
	private String steringHandle;

	public String getSteringHandle() {
		return steringHandle;
	}

	public void setSteringHandle(String steringHandle) {
		this.steringHandle = steringHandle;
	}
}
