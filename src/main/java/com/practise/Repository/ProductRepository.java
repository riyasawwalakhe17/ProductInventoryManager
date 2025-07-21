package com.practise.Repository;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Product;

import com.practise.Utility.HibernateUtility;

public class ProductRepository {

	public void addData(Scanner sc) {
		Product p = new Product();
		sc.nextLine(); // to consume the leftover newline from previous nextInt()

		System.out.print("Enter id: ");
		int id = sc.nextInt();

		sc.nextLine();
		System.out.print("Enter product name: ");
		String pname = sc.nextLine();

		System.out.print("Enter product price: ");
		double price = sc.nextDouble();

	
		System.out.print("Enter quantity: ");
		int quantity = sc.nextInt();

		System.out.print("Enter manufacturer: ");
		String manufacturer = sc.next();

		sc.nextLine(); // again, consume newline

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		p.setId(id);
		p.setName(pname);
		p.setPrice(price);
		p.setQuantity(quantity);
		p.setManufacturer(manufacturer);
	

		session.persist(p);
		transaction.commit();
		session.close();

		System.out.println("Product Details Added successfully ");
	}

	public void AllData(Scanner sc) {

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		// We have to use parameterised query to filter
		List<Product> plist = session.createQuery("select s from Product s", Product.class).getResultList();

		plist.stream().forEach(a -> System.out.println(a.toString()));

		transaction.commit();
		session.close();
	}
	public void updateData(Scanner sc) {
		System.out.println("Enter Id to update product quantity : ");
		int id = sc.nextInt();

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Product p = session.find(Product.class, id);
		System.out.println("Enter new quanity :");
		int update = sc.nextInt();

		p.setQuantity(update);

		transaction.commit();
		session.close();
		System.out.println("Product quanity updated ");
	}

	public void deleteData(Scanner sc) {
		System.out.println("Enter the id to delete product details : ");
		int id = sc.nextInt();

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Product p = session.find(Product.class, id);
		session.remove(p);

		transaction.commit();
		session.close();

		System.out.println("Product details deleted ");
	}
	

}
