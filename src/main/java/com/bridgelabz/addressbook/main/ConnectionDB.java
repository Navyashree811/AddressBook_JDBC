package com.bridgelabz.addressbook.main;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

	static Connection con;

	public static Connection createCP() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/Address_Book_Service", "root", "1234");
		System.out.println("Driver Class Loaded");
		System.out.println("Connetion Establish with db server");
		return con;
	}

}
