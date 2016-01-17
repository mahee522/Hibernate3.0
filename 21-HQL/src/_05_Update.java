import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class _05_Update {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Query query = session.createQuery("UPDATE Emp set salary = :salary WHERE eid = :employee_id");
			query.setParameter("salary",99999.0);
			query.setParameter("employee_id",1);
			int row = query.executeUpdate();
			System.out.println("Rows affected: " + row);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}