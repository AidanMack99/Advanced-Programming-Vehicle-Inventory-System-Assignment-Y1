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
public class LoginFormHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange he) throws IOException {
		
		
		
		he.sendResponseHeaders(200, 0);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));
		out.write("<html><head></head><body><form method=\"POST\" action=\"/login\">");
		out.write("Username:<input name=\"username\"><br>");
		out.write("Password:<input name=\"password\"><br>");
		out.write("<input type=\"submit\" value=\"Submit\">");
		out.write("</form></body></html>");
		
		
		out.close();

		

	
}}
