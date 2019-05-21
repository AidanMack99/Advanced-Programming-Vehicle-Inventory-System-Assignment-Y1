import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpServer;


import java.io.PrintWriter;
//Aidan Mackintosh-Stewart 17004449


public class ControllerServer {
	
	
	
	static Boolean loggedin= false;
	static int userType = 999;
	

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		HttpServer server = HttpServer.create(new InetSocketAddress(8005), 0);
		
		
		
		//show all data in html table
	    server.createContext("/", new ShowHandler());
	    //login
	    server.createContext("/post",new LoginFormHandler());
	    server.createContext("/login", new LoginHandler());
	    //logout
	    server.createContext("/logout", new LogOutHandler());
	    //delete
	    server.createContext("/delete", new HandlerDelete());
	    server.createContext("/deletewrite", new HandlerProcessDelete());
	    //insert
	    server.createContext("/insert", new HandlerInsertVehicle());
	    server.createContext("/insertwrite", new HandlerProcessInsertVehicle());
	    //update
	    server.createContext("/update", new HandlerUpdateVehicle());
	    server.createContext("/updatewrite", new HandlerProcessUpdateVehicle());
	    server.setExecutor(null); //default implementation of threading
	    server.start();
	    System.out.println("The server is up and running on port 8005");
	    												
	}																		
}


