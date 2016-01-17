import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Address;

public class AddressDemo {
	Configuration cfg = new AnnotationConfiguration().configure();
	SessionFactory sf = cfg.buildSessionFactory();

	public static void main(String[] args) {
		AddressDemo demo = new AddressDemo();
		demo.demoHQL1(); 
		demo.demo1();
	}

	public void demoHQL1(){
		System.out.println("HQLDEMO1: Returns entity");
		Session session = sf.openSession(); Transaction tx = session.beginTransaction();
		Query query = session.getNamedQuery("adr.named.query1");
		List<Address> result = query.list();
		for (Address obj: result){
			System.out.println(obj);
		}
		System.out.println();tx.commit(); session.close();
	}

	public void demo1(){
		System.out.println("SQLDEMO1: Returns entity");
		Session session = sf.openSession(); Transaction tx = session.beginTransaction();
		Query query = session.getNamedQuery("adr.native.named.query1");
		List<Address> result = query.list();
		for (Address obj: result){
			System.out.println(obj);
		}
		System.out.println();tx.commit(); session.close();
	}
}