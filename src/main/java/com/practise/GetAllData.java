package com.practise;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Product;
import com.practise.Utility.HibernateUtility;

public class GetAllData {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		List<Product> productList = session.createQuery("select p FROM Product p", Product.class).getResultList();

		productList.stream().forEach(k -> System.out.println(k.toString()));

		transaction.commit();
		session.close();
	}
}
