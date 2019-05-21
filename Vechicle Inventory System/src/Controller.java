import java.util.ArrayList;
import java.util.Scanner;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.sql.SQLException;
//Aidan Mackintosh-Stewart 17004449
public class Controller {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		
		final VehicleDAO dao = new VehicleDAO();	
	
		
				
		//Testing CRUD Operations
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("-----------------------");
		System.out.println("Vehicle Inventory System");
		System.out.println("Choose from these options");
		System.out.println("1 - Retrieve all vehicles");
		System.out.println("2 - Search for vehicle");
		System.out.println("3 - Insert new vehicle into database");
		System.out.println("4 - Update existing vehicle details");
		System.out.println("5 - Delete vehicle from database");
		System.out.println("6 - Exit");
		boolean quit = false;
		int menuItem;
		do {    		
    		System.out.print("Choose menu item: ");

            menuItem = in.nextInt();

            switch (menuItem) {

            case 1:

                 System.out.println("You've chosen item #1");
          		  
                  ArrayList<Vehicle> allVehicles = null;
          		  allVehicles = dao.getAllVehicles();
          		  for (Vehicle v : allVehicles)
          		  {
          			System.out.println("-------------");
          			System.out.println(v);
          			
          		  }

                  break;

            case 2:

                  System.out.println("Please enter vehicle number to find >");


          		  Scanner scfind = new Scanner(System.in);
          		  int vehicleID = scfind.nextInt();
          		  dao.getVehicle(vehicleID);
          		  System.out.print(dao.getVehicle(vehicleID));

                  break;

            case 3:

            	System.out.println("Inserting new vehicle into database:");
                System.out.println("Please enter Vehicle details:");

                System.out.println("Please enter Vehicle ID = ");
                Scanner scvehicleID = new Scanner(System.in);
                int insVehicleID = scvehicleID.nextInt();
                scvehicleID.nextLine();
                
                System.out.println("Please enter Vehicle make= ");
                Scanner scvehiclemake = new Scanner(System.in);
                String insVehiclemake = scvehiclemake.next();
                
                System.out.println("Please enter Vehicle Model= ");
                Scanner scvehiclemodel = new Scanner(System.in);
                String insVehiclemodel = scvehiclemodel.next();

                System.out.println("Please enter Vehicle year= ");
                Scanner scvehicleyear = new Scanner(System.in);
                int insVehicleyear = scvehicleyear.nextInt();
                
                
                System.out.println("Please enter Vehicle price= ");
                Scanner scvehicleprice = new Scanner(System.in);
                int insVehicleprice = scvehicleprice.nextInt();
                
                
                
                System.out.println("Please enter Vehicle License number= ");
                Scanner scvehiclelicensenumber = new Scanner(System.in);
                String insVehiclelicensenumber = scvehiclelicensenumber.nextLine();
                
                System.out.println("Please enter Vehicle Colour= ");
                Scanner scvehiclecolour = new Scanner(System.in);
                String insVehiclecolour = scvehiclecolour.next();
                
                System.out.println("Please enter Vehicle Number of doors= ");
                Scanner scvehicledoors = new Scanner(System.in);
                int insVehicledoors = scvehicledoors.nextInt();
                
                System.out.println("Please enter Vehicle Transmission= ");
                Scanner scvehicletransmission = new Scanner(System.in);
                String insVehicletransmission = scvehicletransmission.next();
                
                System.out.println("Please enter Vehicle mileage= ");
                Scanner scvehiclemileage = new Scanner(System.in);
                int insVehiclemileage = scvehiclemileage.nextInt();
                
                System.out.println("Please enter Vehicle fuel type= ");
                Scanner scvehiclefueltype = new Scanner(System.in);
                String insVehiclefueltype = scvehiclefueltype.next();
                
                System.out.println("Please enter Vehicle engine size= ");
                Scanner scvehicleenginesize = new Scanner(System.in);
                int insVehicleenginesize = scvehicleenginesize.nextInt();
                
                System.out.println("Please enter Vehicle body style= ");
                Scanner scvehiclebodystyle = new Scanner(System.in);
                String insVehiclebodystyle = scvehiclebodystyle.next();
                
                System.out.println("Please enter Vehicle condition= ");
                Scanner scvehiclecondition = new Scanner(System.in);
                String insVehiclecondition = scvehiclecondition.next();
                
                System.out.println("Please enter Vehicle notes= ");
                Scanner scvehiclenotes = new Scanner(System.in);
                String insVehiclenotes = scvehiclenotes.next();
                
                
                Vehicle v = new Vehicle(insVehicleID, insVehiclemake,  insVehiclemodel, insVehicleyear, insVehicleprice, insVehiclelicensenumber, insVehiclecolour, insVehicledoors, insVehicletransmission, insVehiclemileage, insVehiclefueltype, insVehicleenginesize, insVehiclebodystyle,  insVehiclecondition, insVehiclenotes);
            	dao.insertRecordIntoVehicles(v);
            	

                  break;

            case 4:

                  System.out.println("You've chosen item #4");

                 
                  
                  System.out.println("Please enter Vehicle ID = ");
                  Scanner upscvehicleID = new Scanner(System.in);
                  int updVehicleID = upscvehicleID.nextInt();
                  upscvehicleID.nextLine();
                  
                  System.out.println("Please enter Vehicle make= ");
                  Scanner upscvehiclemake = new Scanner(System.in);
                  String updVehiclemake = upscvehiclemake.next();
                  
                  System.out.println("Please enter Vehicle Model= ");
                  Scanner upscvehiclemodel = new Scanner(System.in);
                  String updVehiclemodel = upscvehiclemodel.next();

                  System.out.println("Please enter Vehicle year= ");
                  Scanner upscvehicleyear = new Scanner(System.in);
                  int updVehicleyear = upscvehicleyear.nextInt();
                  
                  System.out.println("Please enter Vehicle price= ");
                  Scanner upscvehicleprice = new Scanner(System.in);
                  int updVehicleprice = upscvehicleprice.nextInt();
                  
                  System.out.println("Please enter Vehicle License number= ");
                  Scanner upscvehiclelicensenumber = new Scanner(System.in);
                  String updVehiclelicensenumber = upscvehiclelicensenumber.nextLine();
                  
                  System.out.println("Please enter Vehicle Colour= ");
                  Scanner upscvehiclecolour = new Scanner(System.in);
                  String updVehiclecolour = upscvehiclecolour.next();
                  
                  System.out.println("Please enter Vehicle Number of doors= ");
                  Scanner upscvehicledoors = new Scanner(System.in);
                  int updVehicledoors = upscvehicledoors.nextInt();
                  
                  System.out.println("Please enter Vehicle Transmission= ");
                  Scanner upscvehicletransmission = new Scanner(System.in);
                  String updVehicletransmission = upscvehicletransmission.next();
                  
                  System.out.println("Please enter Vehicle mileage= ");
                  Scanner upscvehiclemileage = new Scanner(System.in);
                  int updVehiclemileage = upscvehiclemileage.nextInt();
                  
                  System.out.println("Please enter Vehicle fuel type= ");
                  Scanner upscvehiclefueltype = new Scanner(System.in);
                  String updVehiclefueltype = upscvehiclefueltype.next();
                  
                  System.out.println("Please enter Vehicle engine size= ");
                  Scanner upscvehicleenginesize = new Scanner(System.in);
                  int updVehicleenginesize = upscvehicleenginesize.nextInt();
                  
                  System.out.println("Please enter Vehicle body style= ");
                  Scanner upscvehiclebodystyle = new Scanner(System.in);
                  String updVehiclebodystyle = upscvehiclebodystyle.next();
                  
                  System.out.println("Please enter Vehicle condition= ");
                  Scanner upscvehiclecondition = new Scanner(System.in);
                  String updVehiclecondition = upscvehiclecondition.next();
                  
                  System.out.println("Please enter Vehicle notes= ");
                  Scanner upscvehiclenotes = new Scanner(System.in);
                  String updVehiclenotes = upscvehiclenotes.next();
                  Vehicle upd = new Vehicle(updVehicleID, updVehiclemake, updVehiclemodel, updVehicleyear, updVehicleprice, 
                		  updVehiclelicensenumber, updVehiclecolour, updVehicledoors, updVehicletransmission, updVehiclemileage, 
                		  updVehiclefueltype, updVehicleenginesize, updVehiclebodystyle, updVehiclecondition, updVehiclenotes);
                  dao.updateVehicle(upd);

                  break;

            case 5:

                  System.out.println("You've chosen item #5");

                  System.out.println("Please enter vehicle number to find >");


          		  Scanner scdelete = new Scanner(System.in);
          		  int d = scdelete.nextInt();
          		  dao.deleteVehicle(d);

                  break;

            case 6:

                  quit = true;

                  break;

            default:

                  System.out.println("Invalid choice.");

            }

      } while (!quit);

      System.out.println("Bye-bye!");
		
		
		
		
		
	}
	

	
	

}
