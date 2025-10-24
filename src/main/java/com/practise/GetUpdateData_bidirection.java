package com.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.practise.Entity.Tax;
import com.practise.Utility.HibernateUtility;

public class GetUpdateData_bidirection {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Tax tax = session.find(Tax.class, 2);
		tax.setGstPercentage(10.0);
		tax.setCessPercentage(2.5);
		tax.setTaxCode("TX-CARE-12");
		

		/*
		 * Here We need to get document first and then set it so it will change value in
		 */

		
		tax.getProduct().setName("Hair Oil");
		tax.getProduct().setPrice(350);
		tax.getProduct().setManufacturer("Parachute");
		tax.getProduct().setQuantity(7);
		
		
		transaction.commit();
		session.close();
	}
}
