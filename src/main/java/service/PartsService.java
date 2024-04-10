package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import dao.CustomerDaoJTest;
import dao.PartsDao;
import entity.Customer;
import entity.Parts;


public class PartsService {
	static Scanner scan = new Scanner(System.in);	
	public static void addPart() {
		// TODO Auto-generated method stub
		PartsDao partsDao;
		try {
			System.out.println("Enter ID:");
			System.out.println("Enter name:");
			System.out.println("Enter discription:");
			System.out.println("Enter price:");
			partsDao = new PartsDao();
			int isInserted=partsDao.addParts(scan.nextInt(),scan.next(),scan.next(),scan.nextDouble());
			if(isInserted>0) {
				System.out.println("Parts Added Succesfully!");
			}else {
				System.out.println("Parts does not exists...");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void specificParts() {
		// TODO Auto-generated method stub
		System.out.println("Entr id to search the parts");
		int id=scan.nextInt();
		
		try {
			PartsDao partsDao=new PartsDao();
			Parts parts=new Parts();
			System.out.println("Enter id who you Want:");
			parts=partsDao.getSpecificParts(id);
			if(parts!=null) {
				System.out.println(parts);
			}else {
				System.out.println("Parts Does Not Exit");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void editParts() {
		// TODO Auto-generated method stub
		System.out.println("Enter id of the Parts u want to update:");
		int id=scan.nextInt();
		System.out.println("Enter name");
		String name=scan.next();
		System.out.println("Enter discription");
		String discription=scan.next();
		System.out.println("Enter price");
		double price=scan.nextDouble();
		try {
			PartsDao partsDao = new PartsDao();
			int isUpdated=partsDao.editParts(id, name, discription, price);
			if(isUpdated>0) {
				System.out.println("Parts Updated Sucessfully!");
			}else {
				System.out.println("Parts Does not Exists...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void deleteParts() {
		// TODO Auto-generated method stub
		System.out.println("Enter pid to delete the parts:");
		int id= scan.nextInt();
		try {
			PartsDao partsDao = new PartsDao();
			int isRemoved=partsDao.removeThisParts(id);
			if(isRemoved>0) {
				System.out.println("Parts Removed Succesfully!");
			}else {
				System.out.println("Parts Not Found...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void allParts() {
		// TODO Auto-generated method stub
		List<Parts> partsList = new ArrayList<>();
		try {
			PartsDao partsDao = new PartsDao();
			partsDao.getAllParts(partsList);
			for(Parts p : partsList) {
				System.out.println(p);
			}}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	}

