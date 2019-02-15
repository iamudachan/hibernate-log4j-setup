package com.jdbc.createstuden;

import java.sql.Struct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.Student;

public class ReadStrudenDemo {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
											   .addAnnotatedClass(Student.class)
											   .buildSessionFactory();
		System.out.println(sf.getProperties().get("hibernate.default_schema"));
		
		Session s = sf.getCurrentSession();
		try {
		
			Student st3 =  new Student("5555","5551q","55555@qq");
			s.beginTransaction();
			s.save(st3);
			s.getTransaction().commit();
			
			s = sf.getCurrentSession();
			s.beginTransaction();
			
			Student st = s.get(Student.class, st3.getId());
			System.out.println(st.getId());
			
			s.getTransaction().commit();
			
		} finally {
			sf.close();
		}
	}

}
