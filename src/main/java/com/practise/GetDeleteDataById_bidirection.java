package com.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.practise.Entity.Tax;
import com.practise.Utility.HibernateUtility;

public class GetDeleteDataById_bidirection {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Tax tax = session.find(Tax.class, 6);
		session.remove(tax);

		transaction.commit();
		session.close();
	}
}
