package service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.CustomerDao;
import entity.Customer;


public class CustomerService {
	static Scanner scan = new Scanner(System.in);	
	public static void addCustomer() {
		CustomerDao customerDao;
		try {
			System.out.println("Enter ID:");
			System.out.println("Enter name:");
			System.out.println("Enter mobileNo:");
			System.out.println("Enter email:");
			System.out.println("Enter Address:");
			customerDao = new CustomerDao();
			int isInserted=customerDao.addCustomer(scan.nextInt(),scan.next(),scan.next(),scan.next(),scan.next());
			if(isInserted>0) {
				System.out.println("Customer Added Succesfully!");
			}else {
				System.out.println("Custommer does not exists...");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	public static Customer getSpecificCustomer() {
		System.out.println("Entr mobile no to search the customer");
		String mobile=scan.next();
		Customer customer=new Customer();
		try {
			CustomerDao customerDao=new CustomerDao();
			
			System.out.println("Enter mobile no who you Want:");
			customer=customerDao.getSpecificCustomer(mobile);
			if(customer!=null) {
				System.out.println(customer);
			}else {
				System.out.println("Customer Does Not Exit");
			}
			return customer;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
		
	}
	public static void editCustomer() {
		System.out.println("Enter id of the customer u want to update:");
		int id=scan.nextInt();
		System.out.println("Enter name");
		String name=scan.next();
		System.out.println("Enter mobile");
		String mobile=scan.next();
		System.out.println("Enter email");
		String email=scan.next();
		System.out.println("Enter address");
		scan.nextLine();
		String address=scan.nextLine();
		try {
			CustomerDao customerDao = new CustomerDao();
			int isUpdated=customerDao.editCustomer(id, name, mobile, email,address);
			if(isUpdated>0) {
				System.out.println("Customer Updated Sucessfully!");
			}else {
				System.out.println("Customer Does not Exists...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void deleteCustomer() {
		System.out.println("Enter Customer id to remove:");
		int id=scan.nextInt();
		try {
			CustomerDao customerDao = new CustomerDao();
			int isDeleted=customerDao.deletCustomer(id);
			if(isDeleted>0) {
				System.out.println("Customer Deleted Succesfully!");
			}else {
				System.out.println("Customer Does not Exists...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void getAllCustomer() {
		List<Customer> customerList= new ArrayList<>(); 
		try {
			CustomerDao customerDao = new CustomerDao();
			customerDao.getAllCustomers(customerList);
			for (Customer customer : customerList)
			{
				System.out.println(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
}
