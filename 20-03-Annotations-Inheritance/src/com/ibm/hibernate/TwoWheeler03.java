package com.ibm.hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TWO_WHEELER")
public class TwoWheeler03 extends Vehicle03{
	private String steringHandle;

	public String getSteringHandle() {
		return steringHandle;
	}

	public void setSteringHandle(String steringHandle) {
		this.steringHandle = steringHandle;
	}
}
