package com.hibernate.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddressDAODemo {

	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		AddressDAO dao = ctx.getBean("addressDAO", AddressDAO.class);
		dao.myAddress();
		dao.myAddress2();
	}
}
