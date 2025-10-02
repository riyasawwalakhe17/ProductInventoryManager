package com.practise;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Tax;
import com.practise.Utility.HibernateUtility;

public class GetAllData_bidirection {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("List of Products are: ");
		List<Tax> taxList = session.createQuery("select t FROM Tax t", Tax.class).getResultList();

		taxList.stream().forEach(k -> System.out.println(k.toString()));

		transaction.commit();
		session.close();
	}
}
