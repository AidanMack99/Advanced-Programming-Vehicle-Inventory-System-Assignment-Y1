import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
//Aidan Mackintosh-Stewart 17004449
public class LoginHandler implements HttpHandler {
	
	@Override
	public void handle(HttpExchange he) throws IOException  {
		

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
		

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));					
		try {
			
			if(dao.login(post.get("username"), post.get("password")) == true)
			{
				he.sendResponseHeaders(200, 0); //HTTP 200 (OK)
				out.write("<p>Logged in</p> <a href=\"./\">Back to all vehicles</a>");
				ControllerServer.loggedin = true;
				
			}
			else {
				he.sendResponseHeaders(500, 0); //HTTP 500 (Internal Server Error)
				out.write("<p>Incorrect username and password</p> <a href=\"./\">Back to all vehicles</a>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()); 
			he.sendResponseHeaders(500, 0); //HTTP 500 (Internal Server Error)			
		} finally {
			out.close();
			
		}
		
		}
	
	}
		
		
		

