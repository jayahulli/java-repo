package com.sony.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sony.entities.Address;
import com.sony.entities.People;
import com.sony.helper.HibernateUtil;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		People people = new People();
		Address address = new Address();
		
		address.setCity("City_1");
		address.setState("State_1");
		address.setStreet("Street_1");
		
		people.setAddress(address);
		people.setDate(new Date());
		people.setPplId(1);
		people.setPplName("People_1");
		people.setPplPhone("Phone_1");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(people);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

	}

}
