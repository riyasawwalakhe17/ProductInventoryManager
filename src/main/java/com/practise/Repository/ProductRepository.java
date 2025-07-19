package com.practise.Repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Product;

import com.practise.Utility.HibernateUtility;

public class ProductRepository {

	public void addData() {

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Product p = new Product();
		p.setId(106);
		p.setName("Body Wash");
		p.setPrice(400.0);
		p.setManufacturer("Foxtale");
		p.setQuantity(5000);

		session.persist(p);
		transaction.commit();
		session.close();
	}

	public void getAllData() {
	
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		List<Product> plist = session.createQuery("select p from Product p", Product.class).getResultList();
		System.out.println("List of Product Details:");
		plist.stream().forEach(k -> System.out.println(k.toString()));

		transaction.commit();
		session.close();
	}
	public void getUpdatedData() {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Updated Salary Details:");
		Product p = session.find(Product.class, 103);
		p.setQuantity(10000);
		

		transaction.commit();
		session.close();
	}
	public void getDeletedData() {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Deleted Employee Details:");
		Product p = session.find(Product.class, 105);
		session.remove(p);

		transaction.commit();

		session.close();
	}
	

}
