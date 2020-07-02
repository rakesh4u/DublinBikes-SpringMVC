package com.dbs.dublinbikes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnect {
	
	public  void insertRecord(String number,String name,String lat,String lng,String bikeStands,String availableBikestands,String availableBikes,double distance){
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try{
			
			System.out.println("Inside DBConnection insertRecord()-->1");
			
			//Load the Oracle driver class implictly
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			//Creating the connection object
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCLDB","SYSTEM","root");
			
			//Prepared statement to insert record into table
			pstmt=con.prepareStatement("INSERT INTO STATIONS (STATIONNUMBER,NAME,LATITUDE,LONGITUDE,BIKESTANDS,AVAILABLEBIKESTANDS,AVAILABLEBIKES,DISTANCE) values(?,?,?,?,?,?,?,?)");
			
			//Set parameters
			int stationNumber=Integer.parseInt(number);
			pstmt.setInt(1, stationNumber);
			pstmt.setString(2, name);
			pstmt.setString(3, lat);
			pstmt.setString(4, lng);
			pstmt.setString(5, bikeStands);
			pstmt.setString(6, availableBikestands);
			pstmt.setString(7, availableBikes);
			pstmt.setDouble(8, distance);
			System.out.println("Inside DBConnection insertRecord()-->2");

			//Execute Query
			int j=pstmt.executeUpdate();
			System.out.println(j+"records inserted successfully!!");
			
		}catch(Exception ex){
			System.out.println("Exception in DBConnection insertRecord()!!");
			ex.printStackTrace();
		}
		finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Exiting  DBConnection insertRecord()-->3");

	}
	

}
