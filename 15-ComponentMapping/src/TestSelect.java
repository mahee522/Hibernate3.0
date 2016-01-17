import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.ibm.hibernate.Emp;

public class TestSelect {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try{
			Emp e = (Emp)session.get(Emp.class, new Integer(1));
			System.out.println(e.getEid());
			System.out.println(e.getName());
			System.out.println(e.getSalary());
			System.out.println(e.getAddress().getCity());
			System.out.println(e.getAddress().getState());
			System.out.println(e.getAddress().getZip());
		} catch(HibernateException e){
			tx.rollback();
			e.printStackTrace();
		}
	}
}