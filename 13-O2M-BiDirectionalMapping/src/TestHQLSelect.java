import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ibm.hibernate.Dept;

public class TestHQLSelect {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Query q = session.createQuery("from Dept d join d.emps");
			List list = q.list();
			java.util.Iterator itr = list.iterator();
			while (itr.hasNext()) {
				Object[] object = (Object[]) itr.next();
				Dept dept = (Dept) object[0];
				System.out.println(dept.getDeptName()+" "+dept.getDeptNo()+" "+dept.getManager());
			}
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}