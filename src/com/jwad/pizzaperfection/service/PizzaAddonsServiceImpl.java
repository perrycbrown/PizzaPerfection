package com.jwad.pizzaperfection.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.jwad.pizzaperfection.dao.PizzaAddonsDaoJdbcImpl;
import com.jwad.pizzaperfection.domainmodel.PizzaAddonsImpl;

public class PizzaAddonsServiceImpl implements PizzaAddonsService {
	
	ArrayList<PizzaAddonsImpl> pizzaAddons = new ArrayList<PizzaAddonsImpl>();
	ArrayList<PizzaAddonsImpl> selectedPizzaAddons = new ArrayList<PizzaAddonsImpl>();
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
	
	public ArrayList<PizzaAddonsImpl> createPizzaAddonsFromRequest (HttpServletRequest request) {
		
		PizzaAddonsDaoJdbcImpl PizzaAddons = new PizzaAddonsDaoJdbcImpl();
		ArrayList<PizzaAddonsImpl> selectedPizzaAddons = new ArrayList<PizzaAddonsImpl>();
		
		// Get the "addons" params from request:
		 String[] checkedAddons = request.getParameterValues("addons");
		
		// Loop through all the addons, looking up complete info for each,
		// and assigning that info to a PizzaAddonsImpl object, and collect
		// each object into the selectedPizzaaddons array:
		
		if (checkedAddons != null) {
			for (String s: checkedAddons) {
				
				String qty = request.getParameter(s + "_quantity");
				
				PizzaAddonsImpl pizzaAddon = PizzaAddons.get(Integer.parseInt(s), qty);
				System.out.println("Here is addon: " + pizzaAddon);
				selectedPizzaAddons.add(pizzaAddon);
				
			}
		}

		return selectedPizzaAddons;
		
	}
	
	public Double getTotalPrice(ArrayList<PizzaAddonsImpl> pizzaAddons) {
		
		double total = 0;
		
		for (int i=0; i<pizzaAddons.size(); i++) {
			total += pizzaAddons.get(i).getTotal();
		}
		
		return total;
		
	}
	
	public HashMap<String, String> extractIds (ArrayList<PizzaAddonsImpl> requestedAddons) {
		
		HashMap<String, String> ids = new HashMap<String, String>();
		
		for (PizzaAddonsImpl addon: requestedAddons) {
			ids.put( addon.getId(), String.valueOf( addon.getQuantity() ) );
		}
		
		return ids;
		
	}

	@Override
	public String toString() {
		return "PizzaAddonsServiceImpl [pizzaAddons=" + pizzaAddons + "]";
	}



}
