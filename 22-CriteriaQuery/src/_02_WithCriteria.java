import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.ibm.hibernate.Emp;

public class _02_WithCriteria {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Criteria crit = session.createCriteria(Emp.class);
			//crit.add(Restrictions.like("name", "%v%")); 	//Like condition
			//crit.add(Restrictions.between("salary",new Double(25000), new Double(50000))); 	//Between condition
			//crit.add(Restrictions.eq("name", "vikas")); 	//equals constraint
			//crit.add(Restrictions.lt("name", "vikas")); 	//less than constraint
			//crit.add(Restrictions.le("name", "vikas")); 	//less than or equals constraint
			//crit.add(Restrictions.gt("name", "vikas")); 	//less than or equals constraint
			//crit.add(Restrictions.ge("name", "vikas")); 	//less than or equals constraint
			//crit.add(Restrictions.isNull("salary"));
			//crit.add(Restrictions.isNotNull("salary"));
			//crit.add(Restrictions.isEmpty("salary"));
			//crit.add(Restrictions.isNotEmpty("salary"));
			//crit.add(Restrictions.and(Restrictions.gt("name", "swati"), Restrictions.lt("name", "vishal"))); //and expression
			//crit.add(Restrictions.or(Restrictions.gt("name", "swati"), Restrictions.lt("name", "vishal"))); //or expression
			crit.add(Restrictions.gt("salary", 2000.0)); crit.addOrder(Order.desc("salary"));
			List emp = crit.list();
			for (Iterator it = emp.iterator(); it.hasNext();) {
				Emp row = (Emp)it.next();
				System.out.println(row.getEid() + " " + row.getName() + " " + row.getAddress() + " " + row.getSalary());
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}