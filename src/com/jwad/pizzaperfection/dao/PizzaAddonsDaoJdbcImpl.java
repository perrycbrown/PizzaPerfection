package com.jwad.pizzaperfection.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jwad.pizzaperfection.domainmodel.PizzaAddonsImpl;

public class PizzaAddonsDaoJdbcImpl implements PizzaAddonsDao {

	public PizzaAddonsDaoJdbcImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void persist(PizzaAddonsImpl addon) {
		// TODO Auto-generated method stub

	}

	@Override
	public PizzaAddonsImpl get(int addon) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PizzaAddonsImpl addon) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(PizzaAddonsImpl addon) {
		// TODO Auto-generated method stub

	}

	public ArrayList<PizzaAddonsImpl> list(int type) {

		ArrayList<PizzaAddonsImpl> pizzaAddons = new ArrayList<PizzaAddonsImpl>();
		String sql = "";
		
		if (type == 0) {
			// Select all types of pizza addons
			sql = "SELECT price, label, type_label FROM pizzaperfection.pizza_addons AS pa LEFT JOIN pizza_addons_type AS pat ON pa.type = pat.id;";
		}
		else if (type == 1) {
			// Select all drinks addons
			sql = "SELECT price, label, type_label FROM pizzaperfection.pizza_addons AS pa LEFT JOIN pizza_addons_type AS pat ON pa.type = pat.id WHERE pa.type = 1;";
		}
		else if (type == 2) {
			// Select only the bread addons
			sql = "SELECT price, label, type_label FROM pizzaperfection.pizza_addons AS pa LEFT JOIN pizza_addons_type AS pat ON pa.type = pat.id WHERE pa.type = 2;";
		}
		else if (type == 3) {
			// Select only the dessert addons
			sql = "SELECT price, label, type_label FROM pizzaperfection.pizza_addons AS pa LEFT JOIN pizza_addons_type AS pat ON pa.type = pat.id WHERE pa.type = 3;";
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/pizzaperfection";
			Connection con = DriverManager.getConnection(url, "root", "srumn78z");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				pizzaAddons.add(new PizzaAddonsImpl(rs.getString("type_label"), rs.getString("label"), rs.getString("price")));
			}
			
			stmt.close();
            con.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pizzaAddons;

	}

	@Override
	public List<PizzaAddonsImpl> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
