package com.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.practise.Entity.Tax;
import com.practise.Utility.HibernateUtility;

public class GetDataById_bidirection {

public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		System.out.println("Products detail are: ");
		int id = 1;
		Tax tax = session.find(Tax.class, 2);
		
		transaction.commit();
		session.close();
		System.out.println("DATA for tax with id " + id + " : " + tax.toString());
	}
}
