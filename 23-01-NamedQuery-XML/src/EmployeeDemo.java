import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Address;
import com.hibernate.model.Employee;

public class EmployeeDemo {
	Configuration cfg = new AnnotationConfiguration().configure();
	SessionFactory sf = cfg.buildSessionFactory();

	public static void main(String[] args) {
		EmployeeDemo demo = new EmployeeDemo();
		demo.demoHQL1(); 
		demo.demoHQL2();
		demo.demoHQL3();
		demo.demo2();
		demo.demo4();
		demo.demo5();
		demo.demo6();
		demo.demo7();
		demo.demo8();
		demo.demo9();
	}

	public void demoHQL1(){
		System.out.println("HQL: Returns one entity");
		Session session = sf.openSession(); Transaction tx = session.beginTransaction();
		Query query = session.getNamedQuery("emp.named.query1");
		List<Employee> result = query.list();
		for (Employee obj: result){
			System.out.println(obj);
			for (Address adr: obj.getAddresses()){
				System.out.println(adr);
			}
		}
		System.out.println();tx.commit(); session.close();
	}

	public void demoHQL2(){
		System.out.println("HQL: returns few entity properties");
		Session session = sf.openSession(); Transaction tx = session.beginTransaction();
		Query query = session.getNamedQuery("emp.named.query2");
		List<Object[]> result = query.list();
		for (Object[] obj: result){
			System.out.println(obj[0]);
			System.out.println(obj[1]);
		}
		System.out.println();tx.commit(); session.close();
	}
	
	public void demoHQL3(){
		System.out.println("HQL: returns unique result");
		Session session = sf.openSession(); Transaction tx = session.beginTransaction();
		Query query = session.getNamedQuery("emp.named.query3");
		Long result = (Long) query.uniqueResult();
		System.out.println(result);
		System.out.println();tx.commit(); session.close();
	}

	public void demo2(){
		System.out.println("SQL: Returns one entity using resultClass");
		Session session = sf.openSession(); Transaction tx = session.beginTransaction();
		Query query = session.getNamedQuery("emp.native.named.query2");
		List<Employee> result = query.list();
		for (Employee obj: result){
			System.out.println(obj);
			for (Address adr: obj.getAddresses()){
				System.out.println(adr);
			}
		}
		System.out.println();tx.commit(); session.close();
	}
	
	public void demo6(){
		System.out.println("SQL: Returns multiple entity");
		Session session = sf.openSession(); Transaction tx = session.beginTransaction();
		Query query = session.getNamedQuery("emp.native.named.query6");
		List<Object[]> result = query.list();
		for (Object[] obj: result){
			System.out.println(obj[0]);
			System.out.println(obj[1]);
		}
		System.out.println();tx.commit(); session.close();
	}

	public void demo4(){
		System.out.println("SQL: Returns scalars");
		Session session = sf.openSession(); Transaction tx = session.beginTransaction();
		Query query = session.getNamedQuery("emp.native.named.query4");
		List<Object[]> result = query.list();
		for (Object[] obj: result){
			System.out.println(obj[0]);
			System.out.println(obj[1]);
		}
		System.out.println();tx.commit(); session.close();
	}

	public void demo5(){
		System.out.println("SQL: Returns scalars using alias");
		Session session = sf.openSession(); Transaction tx = session.beginTransaction();
		Query query = session.getNamedQuery("emp.native.named.query5");
		List<Object[]> result = query.list();
		for (Object[] obj: result){
			System.out.println(obj[0]);
			System.out.println(obj[1]);
		}
		System.out.println();tx.commit(); session.close();
	}

	public void demo7(){
		System.out.println("SQL: Returns entity + scalar");
		Session session = sf.openSession(); Transaction tx = session.beginTransaction();
		Query query = session.getNamedQuery("emp.native.named.query7");
		List<Object[]> result = query.list();
		for (Object[] obj: result){
			System.out.println(obj[0]);
			System.out.println(obj[1]);
		}
		System.out.println();tx.commit(); session.close();
	}
	
	public void demo9(){
		System.out.println("SQL: Returns scalars from multiple entity");
		Session session = sf.openSession(); Transaction tx = session.beginTransaction();
		Query query = session.getNamedQuery("emp.native.named.query9");
		query.list();
		List<Object[]> result = query.list();
		for (Object[] obj: result){
			System.out.print(obj[0] + " ");
			System.out.println(obj[1]);
		}
		System.out.println();tx.commit(); session.close();
	}
	
	public void demo8(){
		System.out.println("SQL: Returns unique result");
		Session session = sf.openSession(); Transaction tx = session.beginTransaction();
		Query query = session.getNamedQuery("emp.native.named.query8");
		BigDecimal result = (BigDecimal) query.uniqueResult();
		System.out.println(result);
		System.out.println();tx.commit(); session.close();
	}
}