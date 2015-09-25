package com.jwad.pizzaperfection.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jwad.pizzaperfection.domainmodel.PizzaElementImpl;

public class PizzaElementDaoJdbcImpl implements PizzaElementDao {
	
	public PizzaElementDaoJdbcImpl() {

	}

	@Override
	public void persist(PizzaElementImpl pizzaElement) {
		// TODO Auto-generated method stub

	}

	@Override
	public PizzaElementImpl get(int pizzaElementId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PizzaElementImpl pizzaElementId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(PizzaElementImpl pizza) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<PizzaElementImpl> list(int complete) {

		ArrayList<PizzaElementImpl> pizzaElements = new ArrayList<PizzaElementImpl>();
		String sql = "";
		
		if (complete == 1) {
			// Select all types of pizza elements
			sql = "SELECT price, label, type_label FROM pizzaperfection.pizza_elements AS pe LEFT JOIN pizza_elements_type AS pet ON pe.type = pet.id;";
		}
		else if (complete == 2) {
			// Select all types of pizza element, but not "complete" pizza elements
			sql = "SELECT price, label, type_label FROM pizzaperfection.pizza_elements AS pe LEFT JOIN pizza_elements_type AS pet ON pe.type = pet.id WHERE type_label != 'complete';";
		}
		else if (complete == 3) {
			// Select only the "complete" pizza elements
			sql = "SELECT price, label, type_label FROM pizzaperfection.pizza_elements AS pe LEFT JOIN pizza_elements_type AS pet ON pe.type = pet.id WHERE type_lable == 'complete';";
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/pizzaperfection";
			Connection con = DriverManager.getConnection(url, "root", "srumn78z");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				pizzaElements.add(new PizzaElementImpl(rs.getString("type_label"), rs.getString("label"), rs.getDouble("price")));
			}
			
			stmt.close();
            con.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pizzaElements;

	}

}
