package com.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Product;
import com.practise.Utility.HibernateUtility;

public class GetUpdateData {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Product product = session.find(Product.class, 2);
		product.setName("Conditioner");
		product.setPrice(215);
		product.setManufacturer("Tresemme");
		product.setQuantity(70);
		

		/*
		 * Here We need to get document first and then set it so it will change value in
		 */

		
		product.getTax().setGstPercentage(12.0);
		product.getTax().setCessPercentage(0.5);
		product.getTax().setTaxCode("TX-CARE-12");

		transaction.commit();
		session.close();
	}
}
