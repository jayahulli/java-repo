package com.sony.demo;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sony.entities.College;
import com.sony.entities.Student;
import com.sony.helper.HibernateUtil;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		College college = new College();
		college.setCollegeId(1);
		college.setCollegeName("College_1");
		
		Student student1 = new Student();
		student1.setStudentId(101);
		student1.setStudentName("Student_1");
		
		/*Set<Student> setStudent = new HashSet<Student>();
		setStudent.add(student1);
		
		college.setListStudent(setStudent);*/
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session  = sessionFactory.openSession();
		session.beginTransaction();
		session.save(college);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

	}

}
