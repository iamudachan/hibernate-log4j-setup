package com.jdbc.createstuden;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.Student;

public class CreateStudent {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
											   .addAnnotatedClass(Student.class)
											   .buildSessionFactory();
		System.out.println(sf.getProperties().get("hibernate.default_schema"));
		
		Session s = sf.getCurrentSession();
		try {
		
			Student st =  new Student("1q","2q","11@qq");
			s.beginTransaction();
			s.save(st);
			s.getTransaction().commit();
		} finally {
			sf.close();
		}
	}

}
