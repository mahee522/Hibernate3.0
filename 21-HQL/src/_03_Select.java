import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class _03_Select {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Query q = session.createQuery("select e.name,e.salary,e.address from Emp e where e.name like :pattern");
			q.setString("pattern","B%"); 	//'B' is case-sensitive.
			List emps = q.list();
			for (Iterator<Object[]> it = emps.iterator() ; it.hasNext() ;){
				Object[] obj = it.next();
				System.out.println(obj[0] + " " + obj[1] + " " + obj[2]);
			}
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}