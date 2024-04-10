package menu;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Customer;
import entity.Customer_Vehicles;
import entity.Vehicle;
import menu.mainMenu.ECustomerMenu;
import menu.mainMenu.ECustomerServiceMenu;
import menu.mainMenu.EPartsMenu;
import menu.mainMenu.EServiceMenu;
import menu.mainMenu.EVehicleMenu;
import menu.mainMenu.EmainMenu;
import menu.mainMenu.EprocessRequestMenu;
import service.CustomerService;
import service.Customer_VehiclesService;
import service.PartsService;
import service.VehicleService;

public class Menu {
	public static void main(String[]args) {
		EmainMenu choice;
		while ((choice = mainMenu.mainMenuOptions()) != EmainMenu.Exit)
			//calling mainMenuOptions() from MenuOptions.java file
		{
			switch (choice) {
			case customer:
				customerMenu();
				break;
			case parts:
				partsMenu();
				break;
			case vehicle:
				vehicleMenu();
				break;
			case serviceMenu:
				serviceMenu();
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
		}
	}

	//--------------------------Customer Menu----------------------------------//
	private static void customerMenu() {
		ECustomerMenu choice;
		while ((choice = mainMenu.customerMenuOptions()) != ECustomerMenu.Exit) 
			//calling customerMenuOptions() from MenuOptions.java file

		{
			switch (choice) {
			case AddCustomer:
				System.out.println("Add");
				CustomerService.addCustomer();
				break;

			case SpecificCustomer:
				System.out.println("Specific");
				CustomerService.getSpecificCustomer();
				break;
			case EditCustomer:
				System.out.println("Edit");
				CustomerService.editCustomer();
				break;
			case DeletCustomer:
				System.out.println("Delete");
				CustomerService.deleteCustomer();
				break;
			case AllCustomer:
				System.out.println("All");
				CustomerService.getAllCustomer();
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
		}
	}

	//---------------------------Parts Menu-----------------------------------//
	
	private static void partsMenu() {
		EPartsMenu choice;
		while ((choice = mainMenu.partsMenuOptions()) != EPartsMenu.Exit) 
			//calling partsMenuOptions() from MenuOptions.java file
		{
			
			switch (choice) {
			case AddPart:
				System.out.println("Add");
				PartsService.addPart();
				break;

			case SpecificPart:
				System.out.println("Specific");
				PartsService.specificParts();
				break;
			case EditPart:
				System.out.println("Edit");
				PartsService.editParts();
				break;
			case DeletPart:
				System.out.println("Delete");
				PartsService.deleteParts();
				break;
			case AllPart:
				System.out.println("All");
				PartsService.allParts();
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
		}

	}
	
	//--------------------Vehicle Menu----------------------------//
	
	private static void vehicleMenu() {
		EVehicleMenu choice;
		while((choice=mainMenu.vehicleMenuOption()) != EVehicleMenu.Exit) 
			//calling vehicleMenuOption from MenuOptions.java file
		{
			switch(choice) {
			case AddVehicle:
				VehicleService.insertVehicle();
				System.out.println("Add Successfully");
				//adding new vehicle
				break;
			case DisplayAllVehicles:
				VehicleService.allVehicle();
				System.out.println("Display All Successfully");
				//Displaying all vehicle from database
				break;
			case DisplayCustomerVehicles:
//				Customer c=CustomerService.getSpecificCustomer();
//				int ispresent=c.getId();
//				if(ispresent>0) {
//					System.out.println(c.getId());
//					Customer_VehiclesService.specificVehicleNo();
//					Vehicle v1=VehicleService.allVehicle();
//					Vehicle v=
					VehicleService.specificCustomerVehicle();
//					int isPresent=v.getId();
//					if(isPresent>0) {
//						Customer_Vehicles cv=Customer_VehiclesService.specificVehicleNo();
						System.out.println("Display Successfully");
//					}else {
//						System.out.println(v.getId());
//						System.out.println("v is empty");
//					}
					
//				}else {
//					System.out.println("Customer is not found");
//				}
				
				//Edit the vehicle number
				break;
			case Editvehicle:
				VehicleService.editVehicle();
				System.out.println("Edit Successfully");
				//Delete the vehicle
				break;
			case Deletevehicle:
				VehicleService.deleteVehicle();
				System.out.println("Delete Successfully");
				//Delete the vehicle
				break;
			default:
				System.out.println("Wrong choice");
				break;
			}
		}
	}
	
	//-------------------Service Menu-----------------------------//
	
	private static void serviceMenu() {
		EServiceMenu choice;
		while((choice=mainMenu.serviceMenuOption()) !=EServiceMenu.Exit) 
			//calling serviceMenuOption() from MenuOptions.java file
		{
			switch(choice) {
			case SelectCustomer:
				System.out.println("Select Customer Vehicle");
				customerServiceMenu(); // calling this method to display sub menu
				break;
			case ProcessRequest:
				System.out.println("Process Request");
				processRequestMenu(); // calling this method to display sub menu
				break;
			case PrepareAndDisplay:
				System.out.println("Prepare and Display Bill");
				break;
			case GetPaymentFormCustomer:
				System.out.println("Get Payment Form Customer");
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
		}
		
	}	
	//------------sub menu of "Select Customer Vehicle" in serviceMenu---------//
	
	private static void customerServiceMenu()
	{
		ECustomerServiceMenu choice;
		while((choice=mainMenu.serviceCustomerVehicleMenu()) !=ECustomerServiceMenu.Exit) 
			//calling serviceCustomerVehicleMenu() from MenuOptions.java file
		{
			switch(choice) {
			case Choosecustomerfromexistinglist:
				System.out.println("Choose customer from existing list of customers");
				break;
			case Displayhisvehicledetails:
				System.out.println("Display his/her vehicle details");
				break;
			case Choosevehiclefromthelistinputdetailsofnewvehicle:
				System.out.println("Choose vehicle from the list or input details of new vehicle");
				break;
			default:
				System.out.println("Wrong Choice");
				break;
				
			}
		}
		
	}
	
	//----------------------sub menu of "Process Request" in serviceMenu--------------//
	private static void processRequestMenu() 
	{
		EprocessRequestMenu choice;
		while((choice=mainMenu.serviceProcessRequest()) !=EprocessRequestMenu.Exit) 
			//calling serviceProcessRequest() from MenuOptions.java file
		{
			switch(choice) {
			case NewService:
				System.out.println("New Service");
				break;
			case ExistingService:
				System.out.println("Maintenance");
				break;
			case Maintenance:
				System.out.println("Repairing");
				break;
			case OilAdditiveChangeAdd:
				System.out.println("Oil/Additive Change/Add");
				break;
			default:
				System.out.println("Wrong Choice");
				break;
				
			}
		}
		
	}	
	
	
	
}
