package com.sony.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sony.entities.Student_Info;
import com.sony.helper.HibernateUtil;


public class Main {

	public static void main(String[] args) {
		
		
		// Write the Student_Info object into the database
		Student_Info student = new Student_Info();
		student.setName("Gouri");
		student.setRoll_no(2);

		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// this would save the Student_Info object into the database
		session.save(student);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
