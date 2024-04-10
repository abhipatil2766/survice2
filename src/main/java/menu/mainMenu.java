package menu;

import java.util.Scanner;

public class mainMenu {
	
	enum EmainMenu{
		Exit,customer,parts,vehicle,serviceMenu,defalt
	}
	enum ECustomerMenu{
		Exit,AddCustomer,SpecificCustomer,EditCustomer,DeletCustomer,AllCustomer,defalt
	}
	enum EPartsMenu{
		Exit,AddPart,SpecificPart,EditPart,DeletPart,AllPart,defalt
	}
	enum EVehicleMenu{
		Exit,AddVehicle,DisplayAllVehicles,DisplayCustomerVehicles,Editvehicle,Deletevehicle,defalt
	}
	
	
	public static EmainMenu mainMenuOptions() {
		System.out.println("0.EXIT");
		System.out.println("1.Customer");
		System.out.println("2.Parts");
		System.out.println("3.Vehicle");
		System.out.println("4.Services");
		System.out.print("Enter Your Choice = ");
		int choice=new Scanner(System.in).nextInt();
		return (choice<0 || choice>4) ? EmainMenu.values()[5]:EmainMenu.values()[choice];
	}
	
	
	//----------Customer Menu Option-------------------//
	public static ECustomerMenu customerMenuOptions() {
		System.out.println("******Customer Menu Option******");
		System.out.println("0. Previous Menu");
		System.out.println("1. Add Customer");
		System.out.println("2. Specific Customer");
		System.out.println("3. Edit Customer");
		System.out.println("4. Delete Customer");
		System.out.println("5. All Customers");
		System.out.print("Enter Your choice = ");
		int choice =new Scanner(System.in).nextInt();
		return (choice<0 || choice>5) ? ECustomerMenu.values()[6]:ECustomerMenu.values()[choice];
	}
	//-------------Parts Menu Option-----------------//
	public static EPartsMenu partsMenuOptions() {
		System.out.println("******Parts Menu Option******");
		System.out.println("0. Previous Menu");
		System.out.println("1. Add Part");
		System.out.println("2. Specific Part");
		System.out.println("3. Edit Part");
		System.out.println("4. Delete Part");
		System.out.println("5. All Parts");
		System.out.print("Enter Your choice = ");
		int choice =new Scanner(System.in).nextInt();
		return (choice<0 || choice>5) ? EPartsMenu.values()[6]:EPartsMenu.values()[choice];
	}
	//----------Vehicle Menu Option-----------------//
	public static EVehicleMenu vehicleMenuOption() {
		System.out.println("******Vehicle Menu Option******");
		System.out.println("0. Previous Menu");
		System.out.println("1. Add Vehicle");
		System.out.println("2. Display All Vehicles");
		System.out.println("3. Display Customer Vehicles");
		System.out.println("4. Edit Customer");
		System.out.println("5. Delete Customer");
		int choice =new Scanner(System.in).nextInt();
		return (choice<0 || choice>5) ? EVehicleMenu.values()[6]:EVehicleMenu.values()[choice];
	}
	//-----------Service Menu Option---------------//
	enum EServiceMenu{
		Exit,SelectCustomer,ProcessRequest,PrepareAndDisplay,GetPaymentFormCustomer,defalt
	}
	public static EServiceMenu serviceMenuOption() {
		System.out.println("******Service Menu Option******");
		System.out.println("0.Previous Menu");
		System.out.println("1.Select Customer Vehicle");
		System.out.println("2.Process Request");
		System.out.println("3.Prepare and Display Bill");
		System.out.println("4.Get Payment Form Customer");
		int choice =new Scanner(System.in).nextInt();
		return (choice<0 || choice>4) ? EServiceMenu.values()[5]:EServiceMenu.values()[choice];
	}
	//-----------Customer vehicle Menu( sub menu of service)------------------//
	enum ECustomerServiceMenu{
		Exit,Choosecustomerfromexistinglist,Displayhisvehicledetails,Choosevehiclefromthelistinputdetailsofnewvehicle,defalt
	}
	
	public static ECustomerServiceMenu serviceCustomerVehicleMenu() {
		System.out.println("******Customer vehicle Menu( sub menu of service)******");
		System.out.println("0.Previous Menu");
		System.out.println("1.Choose customer from existing list of customers");
		System.out.println("2.Display his/her vehicle details");
		System.out.println("3.Choose vehicle from the list or input details of new vehicle");
		int choice =new Scanner(System.in).nextInt();
		return (choice<0 || choice>3) ? ECustomerServiceMenu.values()[4]:ECustomerServiceMenu.values()[choice];

		
	}
	
	//--------------Process Request Menu(sub menu of service)----------------//
	
	enum EprocessRequestMenu{
		Exit,NewService,ExistingService,Maintenance,OilAdditiveChangeAdd,defalt
	}
	public static EprocessRequestMenu serviceProcessRequest() {
		System.out.println("******Process Request Menu(sub menu of service)******");
		System.out.println("0.Previous Menu");
		System.out.println("1.New Service");
		System.out.println("2.Existing Service");
		System.out.println("3.Maintenance");
		System.out.println("4.Oil/Additive Change/Add");
		int choice =new Scanner(System.in).nextInt();
		return (choice<0 || choice>3) ? EprocessRequestMenu.values()[4]:EprocessRequestMenu.values()[choice];

	}
}
