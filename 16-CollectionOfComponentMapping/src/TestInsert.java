import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ibm.hibernate.Cars;
import com.ibm.hibernate.User;

public class TestInsert {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Set<Cars> mycars = new HashSet<Cars>();
			mycars.add(new Cars("ZEN","MARUTI","Car1"));
			mycars.add(new Cars("ALTO","MARUTI","Car2"));
			User u = new User("Prasanna", mycars);
			session.save(u);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}