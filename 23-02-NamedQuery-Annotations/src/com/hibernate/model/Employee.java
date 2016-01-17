package com.hibernate.model;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name="emp.named.query1", query = "from Employee where id=1"),
	@NamedQuery(name="emp.named.query2", query = "select name, salary from Employee where id=2"),
	@NamedQuery(name="emp.named.query3", query = "select count(*) from Employee")
})
@NamedNativeQueries({
	@NamedNativeQuery(name="emp.native.named.query1", query="SELECT EMP.*, ADR.* FROM EMPLOYEE EMP, ADDRESS ADR WHERE EMP.EMP_ID=ADR.EMP_ID AND EMP.EMP_ID=1 ", resultClass=Employee.class),
	@NamedNativeQuery(name="emp.native.named.query2", query="SELECT * FROM EMPLOYEE WHERE EMP_ID=1", resultClass=Employee.class),
	@NamedNativeQuery(name="emp.native.named.query3", query="SELECT * FROM EMPLOYEE WHERE EMP_ID=2", resultSetMapping="rsMetadata3"),
	@NamedNativeQuery(name="emp.native.named.query6", query="SELECT E.*, A.* FROM EMPLOYEE E, ADDRESS A WHERE E.EMP_ID=A.EMP_ID AND E.EMP_ID=1", resultSetMapping="rsMetadata6"),
	@NamedNativeQuery(name="emp.native.named.query4", query="SELECT EMP_NAME, EMP_SALARY FROM EMPLOYEE WHERE EMP_ID=3", resultSetMapping="rsMetadata4"),
	@NamedNativeQuery(name="emp.native.named.query5", query="SELECT EMP_NAME as NAME, EMP_SALARY as SALARY FROM EMPLOYEE WHERE EMP_ID=4", resultSetMapping="rsMetadata5"),
	@NamedNativeQuery(name="emp.native.named.query7", query="SELECT E.*, A.CITY FROM EMPLOYEE E, ADDRESS A WHERE E.EMP_ID=A.EMP_ID AND E.EMP_ID=2", resultSetMapping="rsMetadata7"),
	@NamedNativeQuery(name="emp.native.named.query9", query="SELECT E.EMP_NAME, A.CITY FROM EMPLOYEE E, ADDRESS A WHERE E.EMP_ID=A.EMP_ID AND E.EMP_ID=2", resultSetMapping="rsMetadata9"),
	@NamedNativeQuery(name="emp.native.named.query8", query="SELECT SUM(EMP_SALARY) as ctc FROM EMPLOYEE", resultSetMapping="rsMetadata8")
})
@SqlResultSetMappings({
	@SqlResultSetMapping(name="rsMetadata3", entities={@EntityResult(entityClass=com.hibernate.model.Employee.class)}),
	/* these are just scalars, so we don't need to know about an entity here */
	@SqlResultSetMapping(name="rsMetadata4", columns={@ColumnResult(name="EMP_NAME"), @ColumnResult(name="EMP_SALARY")}),
	@SqlResultSetMapping(name="rsMetadata5", columns={@ColumnResult(name="NAME"), @ColumnResult(name="SALARY")}),
	@SqlResultSetMapping(name="rsMetadata6", entities={@EntityResult(entityClass=com.hibernate.model.Employee.class),
													   @EntityResult(entityClass=com.hibernate.model.Address.class)}),
    @SqlResultSetMapping(name="rsMetadata7", entities={@EntityResult(entityClass=com.hibernate.model.Employee.class)},
										     columns={@ColumnResult(name="CITY")}),
	@SqlResultSetMapping(name="rsMetadata8", columns={@ColumnResult(name="ctc")}),
	@SqlResultSetMapping(name="rsMetadata9", columns={@ColumnResult(name="EMP_NAME"), @ColumnResult(name="CITY")})
})
@Table(name="EMPLOYEE")
public class Employee {

	@Id
	@Column(name="EMP_ID")
	int id;
	@Column(name="EMP_NAME")
	String name;
	@Column(name="EMP_SALARY")
	int salary;
	// map using either @JoinColumn or mappedBy
	/* @OneToMany(fetch=FetchType.EAGER, mappedBy="emp") */
	@OneToMany
	@JoinColumn(name="EMP_ID")
	Collection<Address> addresses = new HashSet<Address>();
	
	public String toString(){return "ID:" + getId() + " NAME:" + getName() + " SALARY:" + getSalary();}
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getSalary() {return salary;}
	public void setSalary(int salary) {this.salary = salary;}
	public Collection<Address> getAddresses() {return addresses;}
	public void setAddresses(Collection<Address> addresses) {this.addresses = addresses;}	
}
