package dao;




import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import entity.Customer;
import service.CustomerService;

public class CustomerDaoJTest {
	
	@Test
	public void testgetAllCustomers() {
		List<Customer> customer=new ArrayList<>();
		try {
			CustomerDao customerDao=new CustomerDao();
			customerDao.getAllCustomers(customer);
			assertEquals(customer.isEmpty(), false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	@Test
	public void getSpecificCustomer() {
		List<Customer> customer=new ArrayList<>();
		try {
			CustomerDao customerDao=new CustomerDao();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter id which customer you have:");
			int id=sc.nextInt();
//			System.out.println(customerDao.getSpecificCustomer(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	
	@Test
	public void deletCustomer() {
		try {
			CustomerDao customerDao=new CustomerDao();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter id you what want delete:");
			int id= sc.nextInt();
			System.out.println(customerDao.deletCustomer(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

	@Test
	public void addCustomer() {
//		CustomerService.addCustomer();
		
		try {
			
			CustomerDao customerDao=new CustomerDao();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter id:");
			int id=sc.nextInt();
			System.out.println("Enter name:");
			String name=sc.next();
			System.out.println("Enter mobile:");
			String mobile=sc.next();
			System.out.println("Enter email:");
			String email=sc.next();
			System.out.println("Enter address:");
			String address=sc.next();
			System.out.println(customerDao.addCustomer(id,name,mobile,email,address));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	@Test
	public void editCustomer() {

		try {
			CustomerDao customerDao = new CustomerDao();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter id which you want to edit:");
			int id=sc.nextInt();
			System.out.println("Enter name:");
			String name=sc.next();
			System.out.println("Enter mobile:");
			String mobile=sc.next();
			System.out.println("Enter email:");
			String email=sc.next();
			System.out.println("Enter address:");
			String address=sc.next();
			System.out.println(customerDao.editCustomer(id,name,mobile,email,address));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
