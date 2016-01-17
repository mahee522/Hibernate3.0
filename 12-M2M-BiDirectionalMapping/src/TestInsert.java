import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.ibm.hibernate.Course;
import com.ibm.hibernate.Student;

public class TestInsert {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Set<Course> courses = new HashSet<Course>();
			Course c1 = new Course(1,"Java");
			Course c2 = new Course(2,"CS");
			courses.add(c1);
			courses.add(c2);

			Set<Student> students = new HashSet<Student>();
			Student s1 = new Student(100,"Bimal",courses);
			Student s2 = new Student(101,"Meghna",courses);
			students.add(s1);
			students.add(s2);

			session.save(c1);
			session.save(c2);
			session.save(s1);
			session.save(s2);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}