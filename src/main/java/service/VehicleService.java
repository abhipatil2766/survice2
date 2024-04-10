package service;

import java.security.DrbgParameters.NextBytes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.CustomerDao;
import dao.VehicleDao;
import entity.Customer;
import entity.Vehicle;

public class VehicleService {
	static Scanner scan = new Scanner(System.in);
	public static void addVehicle() {
		// TODO Auto-generated method stub
		System.out.println("Enter the vehicle id no:");
		int id=new Scanner(System.in).nextInt();
//		CustomerDao.getSpecificCustomer(id);
		VehicleDao vehicleDao;
		try {
			System.out.println("Enter id");
			System.out.println("Enter Name");
			System.out.println("Enter model");
			vehicleDao =new VehicleDao();
		int isInserted= vehicleDao.addVehicle(scan.nextInt(),scan.next(),scan.next());
		if(isInserted>0) {
			System.out.println("Vehicle Added Succesfully!");
		}else {
			System.out.println("Vehicle does not exists...");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}


	public static Vehicle allVehicle() {
		// TODO Auto-generated method stub
		Vehicle vehicle=new Vehicle();
		List<Vehicle> vehicleList=new ArrayList<>();
		try {
			VehicleDao vehicleDao=new VehicleDao();
			vehicleDao.getAllVehicle(vehicleList);
			for(Vehicle v : vehicleList) {
				System.out.println(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicle;
	}
	
	

	public static Vehicle specificCustomerVehicle() {
		// TODO Auto-generated method stub
		Customer c=CustomerService.getSpecificCustomer();
		Vehicle vehicle=new Vehicle();
		System.out.println("Enter id of vehicle to Fatch that vehicles:");
		int id=scan.nextInt();
//		int id=c.getId();
		try {
			VehicleDao vehicleDao= new VehicleDao();
		
//			System.out.println("Enter id of vehicle you want the specific customer:");
			vehicle=VehicleDao.getspecificVehicle(id);
			if(vehicle!=null) {
				System.out.println(vehicle);
			}else {
				VehicleService.addVehicle();
//				System.out.println("vehicle Does Not Exit");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicle;
	}
	
	

	public static void editVehicle() {
		// TODO Auto-generated method stub
		System.out.println("Enter id of the Vehicle u want to update:");
		int id=scan.nextInt();
		System.out.println("Enter name");
		String name=scan.next();
		System.out.println("Enter model");
		String model=scan.next();
		try {
			VehicleDao vehicleDao=new VehicleDao();
			int isUpdate=vehicleDao.editVehicle(id, name, model);
			if(isUpdate>0) {
				System.out.println("Vehicle Updated Sucessfully!");
			}else {
				System.out.println("Vehicle Does not Exists...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void deleteVehicle() {
		System.out.println("Delete vehicle id you want:");
		int id=scan.nextInt();
		try {
			VehicleDao vehicleDao=new VehicleDao();
			int isremove=vehicleDao.removeVehicle(id);
			if(isremove>0) {
				System.out.println("Remove Vehicle Successfully");
			}else {
				System.out.println("Vehicle does not exist");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public static void insertVehicle() {
		Customer cust=CustomerService.getSpecificCustomer();
		if(cust!=null) {
			System.out.println("Customer Id for mobile number\n"+cust.getMobile()+"id\n"+cust.getId());
			System.out.println("*****VEHICLE LIST*****");
			allVehicle();
			System.out.println("Select your Vehicle id");
			int vehicle_id=scan.nextInt();
			System.out.println("Enter new Vehicle Number");
			String vehicle_number=scan.next();
//			int customer_id=scan.nextInt();
//			int vehicle_id=scan.nextInt();
			VehicleDao.insertCustomerVehicle(vehicle_number,cust.getId(),vehicle_id);
		}else {
			System.out.println("ADD Vehicle Here..");
			System.out.println("Enter Vehicle Details: id, company, model");
//			Vehicle ve=new Vehicle(scan.nextInt(),scan.next(),scan.next());
			String vehicle_number=scan.next();
			
			int customer_id=scan.nextInt();
			int vehicle_id=scan.nextInt();
			VehicleDao.insertCustomerVehicle(vehicle_number,customer_id,vehicle_id);
		}
	}

}
