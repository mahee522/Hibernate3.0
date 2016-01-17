import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class _09_AggregateFunctions {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			//String hql = "select count(*) from Emp e";
			//String hql = "select count(distinct e.salary) from Emp e";
			//String hql = "select avg(e.salary) from Emp e";
			//String hql = "select sum(e.salary) from Emp e";
			String hql = "select max(e.salary) from Emp e";
			//String hql = "select min(e.salary) from Emp e";
			Query query = session.createQuery(hql);
			List list = query.list();
			System.out.println("Output: " + list.get(0));
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}