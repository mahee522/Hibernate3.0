import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.ibm.hibernate.Emp;
import com.ibm.hibernate.MyInterceptor;

public class TestSelect {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession(new MyInterceptor());
		Transaction tx = session.beginTransaction();
		try {
			Emp emp=(Emp)session.get(Emp.class, new Integer(1));
			System.out.println(emp.getEid());
			System.out.println(emp.getName());
			System.out.println(emp.getAddress());
			System.out.println(emp.getSalary());
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}