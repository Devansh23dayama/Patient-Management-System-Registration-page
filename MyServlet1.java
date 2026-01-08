package com.backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet("/myser1")
@WebServlet("/myser1")
public class MyServlet1  extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name= req.getParameter("name");
		String username= req.getParameter("username");
	    String password=req.getParameter("password");
	    String mobile = req.getParameter("mobile");
	    String url = "jdbc:mysql://localhost:3306/registration";
	    String user="root";
	    String pass="root";	
	    
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url,user,pass);
		
	
		PreparedStatement ps = con.prepareStatement("INSERT INTO info (name, username, password, mobile) VALUES (?, ?, ?, ?)");
		
		ps.setString(1, name);
		ps.setString(2, username);
		ps.setString(3, password);
		ps.setString(4, mobile);
		
		int result=  ps.executeUpdate();
		
		if(result >0) {
			System.out.println("data inserted Succesfully ");
		}
		else {
			System.out.println("try again ");
		}
		
		con.close();
    
		}
	    catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	    
			
			
	}
}
