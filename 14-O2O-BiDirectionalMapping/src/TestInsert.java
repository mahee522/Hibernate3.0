import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.ibm.hibernate.Address;
import com.ibm.hibernate.User;

public class TestInsert {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Address sadd = new Address();
			sadd.setCity("Kolkata");
			sadd.setPin(12345);
			User user = new User();
			user.setName("Hemanto");
			user.setAddress(sadd);
			sadd.setUser(user);
			session.save(user);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}