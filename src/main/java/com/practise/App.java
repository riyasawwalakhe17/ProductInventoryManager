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
    			System.out.println("1. Add Product Data");
    			System.out.println("2. View All Products");
    			System.out.println("3. Updated Quantity Details");
    			System.out.println("4. Delete Product by ID");

    			System.out.println("Please Enter your choice: ");
    			int choice = sc.nextInt();

    			ProductRepository user = new ProductRepository();
    			switch (choice) {
    			case 1:
    				System.out.println("Please Enter User ID: ");
    				int productid = sc.nextInt();
    				user.addData();
    				break;
    				
    			case 2:
    				user.getAllData();
    				break;
    				
    			case 3:
    				user.getUpdatedData();
    				break;
//    			
    			case 4:
    				System.out.println("Enter Product ID");
    				int id = sc.nextInt();
    				user.getDeletedData();
    				break;
    			}
        	}
        }
    }

