import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.HashMap;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
//Aidan Mackintosh-Stewart 17004449
public class HandlerProcessUpdateVehicle implements HttpHandler  {

	@Override
	public void handle(HttpExchange he) throws IOException {
		
		VehicleDAO dao = new VehicleDAO();
		HashMap<String,String> post = new HashMap<String,String>();
		//read the request body
		BufferedReader in = new BufferedReader(new InputStreamReader(he.getRequestBody()));
		String line = "";
		String request = "";
		while((line = in.readLine()) != null) {
			request = request + line;
		}
		//individual key=value pairs are delimited by ampersands. Tokenize.
		String[] pairs = request.split("&");					
		for(int i=0;i<pairs.length;i++) {
			//each key=value pair is separated by an equals, and both halves require URL decoding.
			String pair = pairs[i];
			post.put(URLDecoder.decode(pair.split("=")[0],"UTF-8"),URLDecoder.decode(pair.split("=")[1],"UTF-8"));
		}		
		
		
		//get inputs to insert into DAO method
		//convert relevant strings to ints
		
		String s1 = post.get("vehicleid");
		int i1 =  Integer.parseInt(s1);
		
		String s2 = post.get("make");
		
		
		String s3 = post.get("model");
		
		
		String s4 = post.get("year");
		int i4 =  Integer.parseInt(s4);
				
		String s5 = post.get("price");
		int i5 =  Integer.parseInt(s5);
				
		String s6 = post.get("license_number");
		
				
		String s7 = post.get("colour");
		
				
		String s8 = post.get("number_doors");
		int i8 =  Integer.parseInt(s8);
				
		String s9 = post.get("transmission");
		
		
		String s10 = post.get("mileage");
		int i10 =  Integer.parseInt(s10);
		
		String s11 = post.get("fuel_type");
		
		
		String s12 = post.get("engine_size");
		int i12 =  Integer.parseInt(s12);
		
		String s13 = post.get("body_style");
		
		
		String s14 = post.get("condition");
		
		
		String s15 = post.get("notes");
		
		//new vehicle to be inserted
		Vehicle Ins = new Vehicle(i1, s2, s3, i4, i5, s6, s7, i8, s9, i10, s11, i12, s13, s14, s15);
		
				
		

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));					
		try { 
			
			
			dao.updateVehicle(Ins);
			System.out.println(Ins);
			ControllerServer.loggedin = true;
			ControllerServer.userType = 999;
			he.sendResponseHeaders(200, 0); //HTTP 200 (OK)
			out.write("<p>Success!</p> <a href=\"./\">Back to all contacts</a>");
		}
		catch(SQLException se) {
			System.out.println(se.getMessage()); 
			he.sendResponseHeaders(500, 0); //HTTP 500 (Internal Server Error)
			out.write("Error Deleting vehicle");
		} finally {
			out.close();
		}
	}

}
