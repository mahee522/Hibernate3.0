import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.ibm.hibernate.Emp;
import com.ibm.hibernate.EmpCompKey;

public class TestSelect {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Emp e = (Emp) session.get(Emp.class, new EmpCompKey(100,2));
			System.out.println(e.getName());
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}