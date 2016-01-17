import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

import com.ibm.hibernate.Emp;

public class _03_Projections {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Criteria cr = session.createCriteria(Emp.class);
			cr.setProjection(Projections.rowCount());
			//cr.setProjection(Projections.avg("salary"));
			//cr.setProjection(Projections.countDistinct("name"));
			//cr.setProjection(Projections.max("salary"));
			//cr.setProjection(Projections.min("salary"));
			//cr.setProjection(Projections.sum("salary"));
			List emp = cr.list();
			System.out.println(emp.get(0) );
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}