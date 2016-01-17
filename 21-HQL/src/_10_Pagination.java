import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ibm.hibernate.Emp;

public class _10_Pagination {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Query query = session.createQuery("FROM Emp");
			query.setFirstResult(0);
			query.setMaxResults(10);
			List emps = query.list();
			for (Iterator<Emp> it = emps.iterator() ; it.hasNext() ;){
				Emp emp = it.next();
				System.out.println(emp.getEid() + " " + emp.getName() + " " + emp.getSalary() + " " + emp.getAddress());
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}