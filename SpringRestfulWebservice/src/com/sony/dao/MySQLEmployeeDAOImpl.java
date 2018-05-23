package com.sony.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.sony.entities.Employee;
import com.sony.helper.HibernateUtil;

public class MySQLEmployeeDAOImpl implements EmployeeDAO{

	@Override
	public Employee findEmployeeById(int empId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Employee where empId = :empId ");
		query.setInteger("empId", empId);
		Employee employee = (Employee)query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		return employee;
	}

	@Override
	public boolean persistEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		return true;
	}

	@Override
	public boolean updateEmployeeSalaryById(int empId, double empSalary) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Employee>query = session.createQuery("update Employee set empSalary= :empSalary where empId= :empId");
		query.setDouble("empSalary", empSalary);
		query.setInteger("empId", 1);
		int result = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		return true;
	}

	@Override
	public boolean removeEmployee(int empId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Employee>query = session.createQuery("delete from Employee where empId= :empId");
		query.setInteger("empId", empId);
		int result = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		System.out.println("Employee Delete Status="+result);
		return true;
	}

	@Override
	public List<Employee> getAllEmployees() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Employee> query = session.createQuery("from Employee");
		List<Employee> employees = query.list();
		
		for(Employee emp : employees){
			System.out.println(emp);
		}
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		return employees;
	}
	
	

}
