import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.ibm.hibernate.Emp;

public class _01_SelectAll {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Criteria crit = session.createCriteria(Emp.class);
			List emp = crit.list();
			for (Iterator it = emp.iterator(); it.hasNext();) {
				Emp row = (Emp)it.next();
				System.out.println(row.getEid() + " " + row.getName() + " " + row.getAddress() + " " + row.getSalary());
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}