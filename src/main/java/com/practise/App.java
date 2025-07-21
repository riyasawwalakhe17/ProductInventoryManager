package com.practise;

import java.util.Scanner;

import org.hibernate.SessionFactory;


import com.practise.Repository.ProductRepository;
import com.practise.Utility.HibernateUtility;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        	while (true) {
    			Scanner sc = new Scanner(System.in);
    			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
    			System.out.println("WELCOME TO PRODUCT INVENTORY MANAGER");
    			System.out.println("Please Select as per Requirement");
    			System.out.println("1. Add Product");
    			System.out.println("2. View All Products");
    			System.out.println("3. Updated Quantity");
    			System.out.println("4. Delete Product by ID");

    			System.out.println("Please Enter your choice: ");
    			int choice = sc.nextInt();

    			ProductRepository user = new ProductRepository();
    			switch (choice) {
    			case 1:
    				user.addData(sc);
    				break;

    			case 2:
    				user.AllData(sc);
    				break;

    			case 3:
    				user.updateData(sc);
    				break;

    			case 4:
    				user.deleteData(sc);
    				break;
    			}
        	}
        }
    }

