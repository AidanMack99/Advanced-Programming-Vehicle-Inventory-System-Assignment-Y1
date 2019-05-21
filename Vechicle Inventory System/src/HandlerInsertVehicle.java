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
public class HandlerInsertVehicle implements HttpHandler {

	@Override
	public void handle(HttpExchange he) throws IOException {
		
		
		//insert vehicle form
		
		he.sendResponseHeaders(200, 0);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));
		out.write("<html><head></head><body><form method=\"POST\" action=\"/insertwrite\">");
		out.write("Vehicle ID:<input name=\"vehicleid\"><br>");
		out.write("Make:<input name=\"make\"><br>");
		out.write("Model:<input name=\"model\"><br>");
		out.write("Year:<input name=\"year\"><br>");
		out.write("Price:<input name=\"price\"><br>");
		out.write("License Number:<input name=\"license_number\"><br>");
		out.write("Colour:<input name=\"colour\"><br>");
		out.write("Number of Doors:<input name=\"number_doors\"><br>");
		out.write("Transmission:<input name=\"transmission\"><br>");
		out.write("Mileage:<input name=\"mileage\"><br>");
		out.write("Fuel type:<input name=\"fuel_type\"><br>");
		out.write("Engine size:<input name=\"engine_size\"><br>");
		out.write("Body style:<input name=\"body_style\"><br>");
		out.write("Condition:<input name=\"condition\"><br>");
		out.write("Notes:<input name=\"notes\"><br>");
		
		out.write("<input type=\"submit\" value=\"Submit\">");
		out.write("</form></body></html>");
		
		
		
		
	
		
		out.close();

		

	
}}
