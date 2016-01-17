import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.ibm.hibernate.Dept;
import com.ibm.hibernate.Emp;

public class TestSelect {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Dept dept = (Dept) session.get(Dept.class, new Integer(10));
			System.out.println(dept.getDeptName() + " " + dept.getManager());
			Set<Emp> emps = dept.getEmps();
			for (Emp e : emps)
				System.out.println(e.getSalary() + " " + e.getDept().getDeptName());
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}