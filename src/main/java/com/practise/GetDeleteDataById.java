package com.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.practise.Entity.Product;
import com.practise.Utility.HibernateUtility;

public class GetDeleteDataById {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Product product = session.find(Product.class, 1);
		session.remove(product);
		
		System.out.println("Data deleted successfully");

		transaction.commit();
		session.close();
	}
}
