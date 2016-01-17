import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.ibm.hibernate.Address;
import com.ibm.hibernate.Emp;

public class TestSelect {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Emp emp=(Emp)session.get(Emp.class, new Integer(1));
			System.out.println("Emp Name>> " + emp.getName());
			System.out.println("Emp Salary>> " + emp.getSalary());
			Address address = emp.getAddress();
			System.out.println("Emp Address>> " + address.getCity() + " " + address.getState() + " " + address.getZip());
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}