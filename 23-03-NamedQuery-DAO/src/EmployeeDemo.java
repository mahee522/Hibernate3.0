import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.transform.Transformers;

import com.hibernate.model.Address;
import com.hibernate.model.Employee;

public class EmployeeDemo {
	Configuration cfg = new AnnotationConfiguration().configure();
	SessionFactory sf = cfg.buildSessionFactory();

	public static void main(String[] args) {
		EmployeeDemo demo = new EmployeeDemo();
		demo.HQLDemo1();
		demo.HQLDemo2();
		demo.HQLDemo3();
		demo.Demo1();
		demo.Demo2();
		demo.Demo3();
		demo.Demo4();
		demo.Demo5();
		demo.Demo6();
		demo.Demo7();
	}

	public void HQLDemo1(){
		System.out.println("HQL: Returns one entity");
		Session session = sf.openSession();	Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Employee where id > :employee_id");
		query.setParameter("employee_id", 1);
		List<Employee> result = query.list();
		for (Employee employee: result){
			System.out.println(employee);
		}
		System.out.println(); tx.commit(); session.close();
	}

	public void HQLDemo2(){
		System.out.println("HQL: returns few entity properties");
		Session session = sf.openSession();	Transaction tx = session.beginTransaction();
		Query query = session.createQuery("select name, salary from Employee where id=2");
		List<Object[]> result = query.list();
		for (Object[] employee: result){
			System.out.print(employee[0] + " ");
			System.out.println(employee[1]);
		}
		System.out.println(); tx.commit(); session.close();
	}

	public void HQLDemo3(){
		System.out.println("HQL: returns unique result");
		Session session = sf.openSession();	Transaction tx = session.beginTransaction();
		Query query = session.createQuery("select count(*) from Employee");
		System.out.println(query.uniqueResult());
		System.out.println(); tx.commit(); session.close();
	}

	public void Demo1(){
		System.out.println("SQL: Returns one entity");
		Session session = sf.openSession();	Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID > :employee_id");
		query.setParameter("employee_id", 1);
		query.addEntity(Employee.class);
		List<Employee> result = query.list();
		for (Employee employee: result){
			System.out.println(employee); 
		}
		System.out.println(); tx.commit(); session.close();
	}

	public void Demo2(){
		System.out.println("SQL: Returns multiple entity");
		Session session = sf.openSession();	Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("SELECT E.*, A.* FROM EMPLOYEE E, ADDRESS A WHERE E.EMP_ID=A.EMP_ID AND E.EMP_ID > :employee_id");
		query.setParameter("employee_id", 1);
		query.addEntity(Employee.class);
		query.addEntity(Address.class);
		List<Object[]> result= query.list();
		for (Object[] employee: result){
			System.out.print(employee[0] + " "); 
			System.out.println(employee[1]);
		}
		System.out.println(); tx.commit(); session.close();
	}

	public void Demo3(){
		System.out.println("SQL: returns scalars; list of arrays");
		Session session = sf.openSession();	Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID > :employee_id");
		query.setParameter("employee_id", 1);
		query.addScalar("EMP_ID", Hibernate.LONG);
		query.addScalar("EMP_NAME", Hibernate.STRING);
		List<Object[]> result = query.list();
		for (Object[] employee: result){
			System.out.print(employee[0] + " "); 
			System.out.println(employee[1]); 
		}
		System.out.println(); tx.commit(); session.close();
	}

	public void Demo4(){
		System.out.println("SQL: returns scalars; list of map");
		Session session = sf.openSession();	Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID > :employee_id");
		query.setParameter("employee_id", 1);
		query.addScalar("EMP_ID", Hibernate.LONG);
		query.addScalar("EMP_NAME", Hibernate.STRING);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map> result = query.list();
		for (Map employee: result){
			System.out.print(employee.get("EMP_ID") + " "); 
			System.out.println(employee.get("EMP_NAME")); 
		}
		System.out.println(); tx.commit(); session.close();
	}

	public void Demo5(){
		System.out.println("SQL: returns scalars; list of list");
		Session session = sf.openSession();	Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID > :employee_id");
		query.setParameter("employee_id", 1);
		query.addScalar("EMP_ID", Hibernate.LONG);
		query.addScalar("EMP_NAME", Hibernate.STRING);
		query.setResultTransformer(Transformers.TO_LIST);
		List<List> result = query.list();
		for (List employee: result){
			System.out.print(employee.get(0) + " ");
			System.out.println(employee.get(1));
		}
		System.out.println(); tx.commit(); session.close();
	}

	public void Demo6(){
		System.out.println("SQL: returns few entity properties; default values for other properties; column alias must match bean property names");
		Session session = sf.openSession();	Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("SELECT EMP_NAME as name FROM EMPLOYEE WHERE EMP_ID > :employee_id");
		query.setParameter("employee_id", 1);
		query.addScalar("name", Hibernate.STRING);
		query.setResultTransformer(Transformers.aliasToBean(Employee.class));
		List<Employee> result = query.list();
		for (Employee employee: result){
			System.out.println(employee);
		}
		System.out.println(); tx.commit(); session.close();
	}

	public void Demo7(){
		System.out.println("SQL: returns entity + scalar");
		Session session = sf.openSession();	Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("SELECT E.*, A.CITY as CITY FROM EMPLOYEE E, ADDRESS A WHERE E.EMP_ID=A.EMP_ID AND E.EMP_ID > :employee_id");
		query.setParameter("employee_id", 1);
		query.addEntity(Employee.class);
		query.addScalar("CITY", Hibernate.STRING);
		List<Object[]> result = query.list();
		for (Object[] employee: result){
			System.out.print(employee[0] + " "); 
			System.out.println(employee[1]);
		}
		System.out.println(); tx.commit(); session.close();
	}
}