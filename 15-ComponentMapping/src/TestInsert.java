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
		try{
			Address add = new Address();
			add.setCity("Pune");
			add.setState("MH");
			add.setZip("411007");
			Emp emp = new Emp();
			emp.setName("Bimal");
			emp.setSalary(30000);
			emp.setAddress(add);
			session.save(emp);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}