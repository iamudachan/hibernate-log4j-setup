package com.jdbc.createstuden;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.Student;

public class AutoIncreament {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
											   .addAnnotatedClass(Student.class)
											   .buildSessionFactory();
		System.out.println(sf.getProperties().get("hibernate.default_schema"));
		
		Session s = sf.getCurrentSession();
		try {
		
			Student st1 =  new Student("1q","1q","111111@qq");
			Student st2 =  new Student("2q","2q","122221@qq");
			Student st3 =  new Student("3q","3q","13331@qq");
			s.beginTransaction();
			s.save(st1);
			s.save(st2);
			s.save(st3);
			s.getTransaction().commit();
		} finally {
			sf.close();
		}
	}

}
