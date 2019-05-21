import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

//Aidan Mackintosh-Stewart 17004449
public class LogOutHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange he) throws IOException  {
		
		he.sendResponseHeaders(200, 0);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));
		out.write("<p>Logged out</p> <a href=\"./\">Back to all vehicles</a>");
		ControllerServer.loggedin = false;
		ControllerServer.userType = 999;
		out.close();
	}
}
