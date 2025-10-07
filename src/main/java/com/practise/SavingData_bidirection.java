package com.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Product;
import com.practise.Entity.Tax;
import com.practise.Utility.HibernateUtility;

public class SavingData_bidirection {
public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Product product = new Product();
		product.setName("Nail Polish");
		product.setPrice(150);
		product.setManufacturer("Colorbar");
		product.setQuantity(120);
		
		
		Tax tax = new Tax();
		tax.setGstPercentage(18.0);
		tax.setCessPercentage(1.0);
		tax.setTaxCode("TX-MAKEUP-18");
		tax.setProduct(product);
		
		System.out.println("Data Saved successfully");
		
		session.persist(tax);
		transaction.commit();
		session.close();
	}
}
