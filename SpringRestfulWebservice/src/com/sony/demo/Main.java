package com.sony.demo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.sony.entities.Employee;
import com.sony.helper.HibernateUtil;


public class Main {

	public static void main(String[] args) {
		
		
		// Write the Student_Info object into the database
		Employee employee = new Employee();
		employee.setEmpId(2);
		employee.setEmpName("Emp_2");
		employee.setEmpSalary(20000);
		employee.setEmpLocation("Location_2");
		employee.setEmpDesignation("Designation_2");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// this would save the Student_Info object into the database
		//session.save(employee);
	
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
