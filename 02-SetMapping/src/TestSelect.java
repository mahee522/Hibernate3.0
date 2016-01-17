import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ibm.hibernate.Certificate;
import com.ibm.hibernate.Emp;

public class TestSelect {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Emp emp=(Emp)session.get(Emp.class, new Integer(2));
			Set set = emp.getCertificates();
			for(Iterator<Certificate> it = set.iterator(); it.hasNext(); System.out.println("Certificate Name>> " + it.next().getName())) {	}
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}