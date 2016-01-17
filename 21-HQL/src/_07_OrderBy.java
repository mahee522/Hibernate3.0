import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class _07_OrderBy {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Query query = session.createQuery("select e.salary, count(*) from Emp e group by e.salary order by e.salary desc");
			List list = query.list();
			for (Iterator it = list.iterator(); it.hasNext();) {
				Object[] obj = (Object[])it.next();
				System.out.println(obj[0] + "  " + obj[1]);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}