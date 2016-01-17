import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ibm.hibernate.Address;
import com.ibm.hibernate.Emp;

public class TestInsert {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Address address = new Address("Pune","MH","411007");
			session.save(address);	// address should be saved first before associating it with any employee
			Emp emp1 = new Emp("bimal",11111,address);
			//Emp emp2 = new Emp("meghna",33333,address); 	// cannot be saved
			session.save(emp1);
			//session.save(emp2);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}