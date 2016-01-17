import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.ibm.hibernate.Person;
import com.ibm.hibernate.Emp;
import com.ibm.hibernate.Trainee;

public class TestInsert {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Person p = new Person(111,"Bimal");
			Emp e = new Emp(222,"Raju",40000);
			Trainee t = new Trainee(333, "Govind",70000,98);
			session.save(p);
			session.save(e);
			session.save(t);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}