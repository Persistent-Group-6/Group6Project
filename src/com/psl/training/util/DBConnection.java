package com.psl.training.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {
	static Connection cn=null;

	private DBConnection(){
		
	}
	static String driverClass="com.mysql.jdbc.Driver";
	static String url="jdbc:mysql://localhost/order_management_system_db";
	static String username="root";
	static String password="123";
	
	
	public static Connection getConnection(){
		if(cn==null){
			// Optional
			try {
				Class.forName(driverClass);
				cn=DriverManager.getConnection(url,username,password);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
					}
		
		return cn;
		
	
	}
	
	public void closeConnection(){
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
