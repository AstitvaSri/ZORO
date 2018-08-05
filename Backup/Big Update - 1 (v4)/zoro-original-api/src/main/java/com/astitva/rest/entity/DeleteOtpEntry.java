package com.astitva.rest.entity;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class DeleteOtpEntry {
	
	public void deleteEntryFromDB(String email) {
		
		
	
	try {			
			
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zorodb?useSSL=false", "root", "root");
		String sql = "delete from otp_entries where unverified_emails = ?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, email.trim());
		ps.executeUpdate();
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}	
		
	}
}
