package com.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {

	public boolean validate(String username, String password) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "root");
		PreparedStatement ps = con.prepareStatement("select* from info Where username=? AND password=?");
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			return true;
		}

		con.close();

		return false;

	}

}
