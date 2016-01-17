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
			TreeMap<String, Certificate> cert = new TreeMap<String, Certificate>();
			cert.put("Java Basic", new Certificate("SCJP7.0"));
			cert.put("Java Advance", new Certificate("SCWCD"));
			cert.put("Java Framework", new Certificate("Struts"));
			Emp emp = new Emp("bimal","401",44444, cert);
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