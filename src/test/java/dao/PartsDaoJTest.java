package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import entity.Parts;



public class PartsDaoJTest {
	@Test
	public void testgetAllParts() {
		List<Parts> parts=new ArrayList<>();
		try {
			PartsDao partsDao=new PartsDao();
			partsDao.getAllParts(parts);
			assertEquals(parts.isEmpty(), false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	@Test
	public void getSpecificParts() {
		List<Parts> customer=new ArrayList<>();
		try {
			PartsDao partsDao=new PartsDao();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter id which patr you have:");
			int id=sc.nextInt();
			System.out.println(partsDao.getSpecificParts(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	
	@Test
	public void deletParts() {
		try {
			PartsDao partsDao=new PartsDao();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter id you what want delete:");
			int id= sc.nextInt();
			System.out.println(partsDao.removeThisParts(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

	@Test
	public void addParts() {
//		CustomerService.addCustomer();
		
		try {
			
			PartsDao partsDao=new PartsDao();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter id:");
			int id=sc.nextInt();
			System.out.println("Enter name:");
			String name=sc.next();
			System.out.println("Enter discription:");
			String discription=sc.next();
			System.out.println("Enter price:");
			double price=sc.nextDouble();
			System.out.println(partsDao.addParts(id,name,discription,price));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	@Test
	public void editParts() {

		try {
			PartsDao partsDao=new PartsDao();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter id:");
			int id=sc.nextInt();
			System.out.println("Enter name:");
			String name=sc.next();
			System.out.println("Enter discription:");
			String discription=sc.next();
			System.out.println("Enter price:");
			double price=sc.nextDouble();
			System.out.println(partsDao.editParts(id,name,discription,price));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
