import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.ibm.hibernate.Emp;

public class _01_StandardCacheRegion {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Query q = session.createQuery("from Emp");
			q.setCacheable(true);
			List emps = q.list();
			for (Iterator<Emp> it = emps.iterator() ; it.hasNext() ;){
				Emp emp = it.next();
				System.out.println(emp.getEid() + " " + emp.getName() + " " + emp.getSalary() + " " + emp.getAddress());
			}
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}