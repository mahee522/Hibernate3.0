package com.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AddressDAO {
	@Autowired
	SessionFactory sessionFactory;

	public void myAddress(){
		System.out.println("Using Hibernate transaction & openSession()");
		Query query = sessionFactory.openSession().createSQLQuery("SELECT COUNT(*) FROM ADDRESS");
		System.out.println(query.uniqueResult());
	}
	
	@Transactional
	public void myAddress2(){
		System.out.println("Using Spring transaction & getCurrentSession()");
		Query query = sessionFactory.getCurrentSession().createSQLQuery("SELECT COUNT(*) FROM ADDRESS");
		System.out.println(query.uniqueResult());
	}
	
}
