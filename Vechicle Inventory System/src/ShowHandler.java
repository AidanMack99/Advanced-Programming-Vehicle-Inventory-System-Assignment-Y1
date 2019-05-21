import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
//Aidan Mackintosh-Stewart 17004449
public class ShowHandler implements HttpHandler {
	
	@Override
	public void handle(HttpExchange he) throws IOException  {
		
		
		VehicleDAO dao = new VehicleDAO();
		
		//html table and login button
		
		String head ="<html><head></head><body>  <form method = \"POST\" action=\"/post\"/\">\r\n" + 
				"         <button type=\"submit\">Login</button>\r\n" + 
				"      </form><table><tr><th>VehicleID</th><th>Make</th><th>Model</th><th>Year</th><th>Price</th><th>License Number</th><th>Colour</th><th>Number of Doors</th><th>Transmission</th><th>Mileage</th><th>Fuel Type</th><th>Engine Size</th><th>Body Style</th><th>Condition</th><th>Notes</th></tr>";
		String response = "</table></body></html>";
		
		BufferedWriter out = new BufferedWriter(new
				OutputStreamWriter(he.getResponseBody()));

		ArrayList<Vehicle> allVehicles = new ArrayList<>();
		he.sendResponseHeaders(200, 0); 
		try {
			allVehicles = dao.getAllVehicles();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		 out.write(head);
		 
 		 String tableBody = "";
 		 
 		 
 		  for (Vehicle v : allVehicles)
 		  {
 			
 			  tableBody += "<tr><td>" + v.getVehicle_id() + "</td> " + "</td> " + "<td>"
 			 		  + v.getMake() + "</td> " + "<td>" + v.getModel() + "</td> " + "<td>" 
 			 		  + v.getYear() + "</td> " + "<td>" + v.getPrice() + "</td> " + "<td>" + v.getLicense_number()
 			 		  + "</td> " + "<td>" + v.getColour() + "</td>" + "<td>" + v.getNumber_doors() + "</td> " 
 			 		  + "<td>" + v.getTransmission() + "</td> " + "<td>" + v.getMileage() + "</td> " + "<td>" 
 			 		  + v.getFuel_type() + "</td> " + "<td>" + v.getEngine_size() + "</td> " + "<td>" 
 			 		  + v.getBody_style() + "</td> " + "<td>" + v.getCondition() + "</td> " + "<td>" 
 			 		  + v.getNotes() + "</td>";
 			
 			  //check for login
 			   if (ControllerServer.loggedin == true && ControllerServer.userType != 1) {
 				 out.write("<form method = \"POST\" action=\"/logout\"/\"><button type=\"submit\">Logout</button></form>" );
 				out.write("<form method = \"POST\" action=\"/delete\"/\"><button type=\"submit\">Delete Vehicle</button></form>" ); 
 				out.write("<form method = \"POST\" action=\"/insert\"/\"><button type=\"submit\">Insert Vehicle</button></form>" ); 
 				out.write("<form method = \"POST\" action=\"/update\"/\"><button type=\"submit\">Update Vehicle</button></form>" ); 
 				 ControllerServer.userType = 1;
 	 			  }
 			  }
 		 out.write(tableBody);
		 out.write(response);				
		 out.close();
 			
 		  }
		
		
		 
		 
		 
		 
		

	}


