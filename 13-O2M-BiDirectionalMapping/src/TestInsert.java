import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.ibm.hibernate.Dept;
import com.ibm.hibernate.Emp;

public class TestInsert {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Set<Emp> emps = new HashSet<Emp>();
			emps.add(new Emp(100, "Hemant", 40000));
			emps.add(new Emp(101, "Meghna", 50000));
			Dept dept = new Dept(10, "Accounts", "Bimal", emps);
			session.save(dept);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}