package com.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Product;
import com.practise.Entity.Tax;
import com.practise.Utility.HibernateUtility;

public class SavingData {

	
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Tax tax = new Tax();
		tax.setGstPercentage(0.5);
		tax.setCessPercentage(1.5);
		tax.setTaxCode("TX-EYE-05");
		
		Product product = new Product();
		product.setName("Kajal");
		product.setPrice(250);
		product.setManufacturer("Lakme");
		product.setQuantity(50);
		product.setTax(tax);
		
		session.persist(product);
		transaction.commit();
		session.close();
	}
}
