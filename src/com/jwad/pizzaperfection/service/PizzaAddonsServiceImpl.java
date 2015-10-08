package com.jwad.pizzaperfection.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.jwad.pizzaperfection.dao.PizzaAddonsDaoJdbcImpl;
import com.jwad.pizzaperfection.domainmodel.PizzaAddonsImpl;

public class PizzaAddonsServiceImpl implements PizzaAddonsService {
	
	ArrayList<PizzaAddonsImpl> pizzaAddons = new ArrayList<PizzaAddonsImpl>();
	private HashMap<String, String> pizzaaddonshash;

	public PizzaAddonsServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<PizzaAddonsImpl> getPizzaAddons(int type) {

		PizzaAddonsDaoJdbcImpl PizzaAddons = new PizzaAddonsDaoJdbcImpl();
		return PizzaAddons.list(type);
		
	}
	
	public HashMap<String, String> convertPizzaAddons(ArrayList<PizzaAddonsImpl> pizzaaddons) {
		
		for (PizzaAddonsImpl addon : pizzaaddons) {
			pizzaaddonshash.put(addon.getLabel(), addon.getPrice());
		}
		return pizzaaddonshash;

	}
	
	public PizzaAddonsImpl createPizzaAddonsFromRequest (HttpServletRequest request) {

		PizzaAddonsImpl pizzaAddon = new PizzaAddonsImpl(
				request.getParameter("id"),
				request.getParameter("label"),
				request.getParameter("price"),
				request.getParameter("type_label")
				);

		return pizzaAddon;
		
	}

	@Override
	public String toString() {
		return "PizzaAddonsServiceImpl [pizzaAddons=" + pizzaAddons + "]";
	}

}
