package com.jwad.pizzaperfection.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public class ConnectionDao {
	
	public static Connection get() {
		String url = "jdbc:mysql://localhost/pizzaperfection";
		java.sql.Connection con = null;
		try {
			con = DriverManager.getConnection(url, "root", "srumn78z");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
