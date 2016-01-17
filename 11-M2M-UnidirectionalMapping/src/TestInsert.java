import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ibm.hibernate.Certificate;
import com.ibm.hibernate.Emp;

public class TestInsert {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Set<Certificate> cert = new HashSet<Certificate>();
			cert.add(new Certificate("SCJP7.0"));
			cert.add(new Certificate("SCWCD"));
			cert.add(new Certificate("Struts"));
			cert.add(new Certificate("Struts"));	// Not added to the collection
			Emp emp = new Emp("bimal",88888, cert);
			session.save(emp);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}