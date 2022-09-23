package com.example.demo.utils;
import java.sql.*;


import java.util.ResourceBundle;
import java.io.*;
public class ConnectionFactory {

	
		public static Connection getMySqlConnection() {
			Connection con=null;
			
			try {
				ResourceBundle bundle=ResourceBundle.getBundle("application");
				
				String url=bundle.getString("datasource.url");
				String userName=bundle.getString("datasource.username");
				String passWord=bundle.getString("datasource.password");
				
				con=DriverManager.getConnection(url,userName,passWord);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return con;
	
		
	}

	
}
