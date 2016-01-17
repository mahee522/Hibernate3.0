import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ibm.hibernate.Emp;

public class TestNamedQuery {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try{
			//Query q = session.getNamedQuery("getAllEmps");
			//Query q = session.getNamedQuery("getEmps");
			Query q=session.getNamedQuery("storedprocedure");
			List list = q.list();
			Iterator itr= list.iterator();
			while (itr.hasNext()) {
				Emp emp = (Emp) itr.next();
				System.out.println(emp.getName() + " " + emp.getSalary());}
			tx.commit();
		} catch(HibernateException e){
			tx.rollback();
			e.printStackTrace();
		}
	}
}