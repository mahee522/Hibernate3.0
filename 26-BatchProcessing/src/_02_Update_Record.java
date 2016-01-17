import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.ibm.hibernate.Emp;

public class _02_Update_Record {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		ScrollableResults employeeCursor = session.createQuery("FROM Emp e").scroll();
		int count = 0;
		while ( employeeCursor.next() ) {
			Emp employee = (Emp) employeeCursor.get(0);
			employee.setSalary(1000.0);
			session.update(employee); 
			if ( ++count % 50 == 0 ) {
				session.flush();
				session.clear();
			}
		}
		tx.commit();
		session.close();
	}
}