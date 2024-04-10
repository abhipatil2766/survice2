package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import entity.Vehicle;



public class VehicleDaoJTest {
	@Test
	public void testgetAllVehicle() {
		List<Vehicle> vehicle=new ArrayList<>();
		try {
			VehicleDao vehicleDao=new VehicleDao();
			vehicleDao.getAllVehicle(vehicle);
			assertEquals(vehicle.isEmpty(), false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	@Test
	public void getSpecificVehicle() {
		List<Vehicle> vehicle=new ArrayList<>();
		try {
			VehicleDao vehicleDao=new VehicleDao();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter id which vehicle you have:");
			int id=sc.nextInt();
//			System.out.println(vehicleDao.getSpecificVehicle(id));
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
