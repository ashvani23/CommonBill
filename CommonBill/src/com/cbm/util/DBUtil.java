package com.cbm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	public static String url="jdbc:oracle:thin:@172.24.137.30:1521:orcl";
	public static String url2="jdbc:oracle:thin:@localhost";
	public static Connection con=null;
	
	
	public static Connection getConnection()  {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection(url2, "commonBill", "1234");
			System.out.println("Connection Made");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void closeResultSet(ResultSet rs)  {
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void closeStatement(PreparedStatement PS)  {
		if(PS!=null){
			try {
				PS.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void closeConnection(Connection con)  {
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


