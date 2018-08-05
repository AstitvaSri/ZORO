package com.astitva.rest.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class OtpDbEntry {
	
	public void saveOtp(String email,String otp) {
		 SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UnverifiedEntries.class).buildSessionFactory();

			System.out.println("Factory created");
		Session session=factory.openSession();
		System.out.println("Session Opened");
	
	try {
		
		int refId = 0;
			session.beginTransaction();
			List<UnverifiedEntries> listEntries = session.createQuery("from UnverifiedEntries u where u.unverifiedEmail='"+email+"'").getResultList();
			
			if(listEntries.isEmpty()) {
				UnverifiedEntries newEntry = new UnverifiedEntries(email, otp);
				session.save(newEntry);
			}
			
			else {				
			
				for(UnverifiedEntries temp:listEntries) {
				refId=temp.getId();
					}
			
				UnverifiedEntries ue=session.get(UnverifiedEntries.class, refId);
				ue.setCurrentOtp(otp);
			}
	
		
		session.getTransaction().commit(); //it automatically saves any update  performed
		
	}
	finally {
		factory.close();
	}	
		
		
	}
	
	
	
}
