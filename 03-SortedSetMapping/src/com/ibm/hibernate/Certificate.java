package com.ibm.hibernate;

public class Certificate implements Comparable <Certificate> {
	private int id;
	private String name; 

	public Certificate() {}
	public Certificate(String name) { this.name = name; }
	
	public int getId() { return id; }
	public void setId( int id ) { this.id = id; }
	
	public String getName() { return name; }
	public void setName( String name ) { this.name = name; }
	
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!this.getClass().equals(obj.getClass())) return false;

		Certificate obj2 = (Certificate)obj;
		if((this.id == obj2.getId()) && (this.name.equals(obj2.getName()))) return true;
		return false;
	}
	public int hashCode() { return ( id + name ).hashCode(); }
	public int compareTo(Certificate that){
		final int BEFORE = -1;
		final int AFTER = 1;

		if (that == null) return BEFORE;

		Comparable thisCertificate = this.getName();
		Comparable thatCertificate = that.getName();

		if(thisCertificate == null) return AFTER;
		else if(thatCertificate == null) return BEFORE;
		else return thisCertificate.compareTo(thatCertificate);
	}
}