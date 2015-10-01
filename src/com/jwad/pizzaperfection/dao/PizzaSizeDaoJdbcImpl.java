package com.jwad.pizzaperfection.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jwad.pizzaperfection.domainmodel.PizzaSizeImpl;

public class PizzaSizeDaoJdbcImpl implements PizzaSizeDao {
	
	public PizzaSizeDaoJdbcImpl() {

	}

	@Override
	public void persist(PizzaSizeImpl pizzaSize) {
		// TODO Auto-generated method stub

	}

	@Override
	public PizzaSizeImpl get(int pizzaSizeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PizzaSizeImpl pizzaSizeId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(PizzaSizeImpl pizza) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<PizzaSizeImpl> list() {

		ArrayList<PizzaSizeImpl> pizzaSizes = new ArrayList<PizzaSizeImpl>();
		String sql = "SELECT label, multiplier FROM pizzaperfection.pizza_sizes;";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/pizzaperfection";
			Connection con = DriverManager.getConnection(url, "root", "srumn78z");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				pizzaSizes.add(new PizzaSizeImpl(rs.getString("label"), rs.getDouble("multiplier")));
			}
			
			stmt.close();
            con.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pizzaSizes;

	}

}
